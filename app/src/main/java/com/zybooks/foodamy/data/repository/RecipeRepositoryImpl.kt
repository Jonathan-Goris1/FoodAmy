package com.zybooks.foodamy.data.repository

import androidx.paging.*
import com.zybooks.foodamy.data.local.dao.RecipeDao
import com.zybooks.foodamy.data.local.dao.RemoteKeysDao
import com.zybooks.foodamy.data.mapper.toDomainModel
import com.zybooks.foodamy.data.remote.network_api.RecipeApi
import com.zybooks.foodamy.data.repository.base.BaseRepository
import com.zybooks.foodamy.data.utils.RecipeEditorRemoteMediator
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

    override suspend fun getRecipeById(recipeId: Int, onlyRemote: Boolean): Recipe =
        execute {
            if (onlyRemote) {
                recipeApi.getRecipe(recipeId).toDomainModel()
            } else {
                fetchFromLocal { recipeDao.getRecipeDetails(recipeId).toDomainModel() }!!
            }
        }


    companion object {
        private const val PAGE_SIZE = 24
        private const val MAX_SIZE = 100
    }

}

