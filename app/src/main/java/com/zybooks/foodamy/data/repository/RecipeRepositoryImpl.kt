package com.zybooks.foodamy.data.repository

import androidx.paging.*
import com.zybooks.foodamy.data.local.dao.RecipeDao
import com.zybooks.foodamy.data.local.dao.RemoteKeysDao
import com.zybooks.foodamy.data.mapper.toDomainModel
import com.zybooks.foodamy.data.mapper.toLocalDto
import com.zybooks.foodamy.data.remote.network_api.RecipeApi
import com.zybooks.foodamy.data.repository.base.BaseRepository
import com.zybooks.foodamy.data.utils.CommentsRemoteMediator
import com.zybooks.foodamy.data.utils.RecipeEditorRemoteMediator
import com.zybooks.foodamy.data.utils.RemoteMediatorCategories
import com.zybooks.foodamy.domain.model.Category
import com.zybooks.foodamy.domain.model.Comment
import com.zybooks.foodamy.domain.model.Recipe
import com.zybooks.foodamy.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@OptIn(ExperimentalPagingApi::class)
class RecipeRepositoryImpl @Inject constructor(
    private val recipeApi: RecipeApi,
    private val recipeDao: RecipeDao,
    private val remoteKeysDao: RemoteKeysDao,

    ): RecipeRepository, BaseRepository() {

    private val pageConfig = PagingConfig(
        pageSize = PAGE_SIZE,
        maxSize = MAX_SIZE,
        enablePlaceholders = false
    )


    override suspend fun getEditorChoicePaging(): Flow<PagingData<Recipe>> =
        execute {
            val pagingSourceFactory = { recipeDao.getEditorChoicesPaging() }
            Pager(
                config = pageConfig,
                remoteMediator = RecipeEditorRemoteMediator(
                    recipeApi = recipeApi,
                    recipeDao = recipeDao,
                    remoteKeysDao = remoteKeysDao
                ),
                pagingSourceFactory = pagingSourceFactory
            ).flow.map { pagingData ->
                pagingData.map {
                    it.toDomainModel()
                }
            }
        }

    override suspend fun getRecipeCommentsPaging(recipeId: Int): Flow<PagingData<Comment>> =
        execute {
            val pagingSourceFactory = { recipeDao.getRecipeCommentsPaging(recipeId) }
            Pager(
                config = pageConfig,
                remoteMediator = CommentsRemoteMediator(
                    recipeApi = recipeApi,
                    recipeDao = recipeDao,
                    remoteKeysDao = remoteKeysDao,
                    recipeId = recipeId
                ),
                pagingSourceFactory = pagingSourceFactory
            ).flow.map { pagingData ->
                pagingData.map { it.toDomainModel() }
            }
        }

    override suspend fun getEditorChoiceRecipes(page: Int): List<Recipe> =
        execute {
            val local = fetchFromLocal { recipeDao.getEditorChoices().map { it.toDomainModel() } }
            if (local?.isNotEmpty() == true) {
                local
            } else {
                val remote = recipeApi.getEditorsChoice(page).data
                saveToLocal { recipeDao.insertRecipes(remote.map { it.toLocalDto()}) }
                remote.map { it.toDomainModel() }
            }
        }

    override suspend fun getFirstComment(recipeId: Int): Comment =
        execute {
                val remote = recipeApi.getRecipeComments(recipeId, 1).data[0]
                saveToLocal { recipeDao.insertComment(remote.toLocalDto(recipeId)) }
                remote.toDomainModel()
        }


    override suspend fun getRecipeById(recipeId: Int, onlyRemote: Boolean): Recipe =
        execute {
            if (onlyRemote) {
                recipeApi.getRecipe(recipeId).toDomainModel()
            } else {
                fetchFromLocal { recipeDao.getRecipeDetails(recipeId).toDomainModel() }!!
            }
        }

    override suspend fun getCategoriesPaging(): Flow<PagingData<Category>> =
        execute {
            val pagingSourceFactory = { recipeDao.getCategoriesPaging() }
            Pager(
                config = pageConfig,
                remoteMediator = RemoteMediatorCategories(
                    recipeApi = recipeApi,
                    recipeDao = recipeDao,
                    remoteKeysDao = remoteKeysDao
                ),
                pagingSourceFactory = pagingSourceFactory
            ).flow.map { pagingData ->
                pagingData.filter {
                    // Some categories has no recipes
                    it.recipes?.isNotEmpty()!!
                }.map {
                    it.toDomainModel()
                }
            }
        }


    companion object {
        private const val PAGE_SIZE = 24
        private const val MAX_SIZE = 100
    }

}

