package com.zybooks.foodamy.data.utils

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.zybooks.foodamy.data.local.dao.RecipeDao
import com.zybooks.foodamy.data.local.dao.RemoteKeysDao
import com.zybooks.foodamy.data.local.local_dto.CategoryDb
import com.zybooks.foodamy.data.local.local_dto.RemoteKeysCategory
import com.zybooks.foodamy.data.mapper.toLocalDto
import com.zybooks.foodamy.data.remote.network_api.RecipeApi

@ExperimentalPagingApi
class RemoteMediatorCategories(
    private val recipeApi: RecipeApi,
    private val recipeDao: RecipeDao,
    private val remoteKeysDao: RemoteKeysDao
) : RemoteMediator<Int, CategoryDb>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CategoryDb>
    ): MediatorResult {
        return try {

            val utils = RemoteMediatorUtils<Int, CategoryDb>(
                remoteKeysDao = remoteKeysDao,
                keyType = PagingKeyType.BY_CATEGORY
            )
            val currentPage = when (val keyData = utils.getPageKey(loadType, state)) {
                is MediatorResult.Success -> {
                    return keyData
                }
                else -> {
                    keyData as Int
                }
            }
            val response = recipeApi.getCategoriesWithRecipes(currentPage)
            val endOfPagination = response.data.isEmpty()

            val prevPage = if (currentPage == STARTING_INDEX) null else currentPage - 1
            val nextPage = if (endOfPagination) null else currentPage + 1

            if (loadType == LoadType.REFRESH) {
                remoteKeysDao.deleteCategoryRecipesKeys()
                recipeDao.deleteCategories()
            }

            val keys = response.data.map {
                RemoteKeysCategory(
                    id = it.id,
                    prev = prevPage,
                    next = nextPage
                )
            }
            remoteKeysDao.insertCategoryRecipesRemoteKeys(keys)
            recipeDao.insertCategories(response.data.map { it.toLocalDto() })

            MediatorResult.Success(endOfPaginationReached = endOfPagination)
        } catch (ex: Exception) {
            MediatorResult.Error(ex)
        }
    }

    companion object {
        private const val STARTING_INDEX = 1
    }
}