package com.zybooks.foodamy.data.utils

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.zybooks.foodamy.data.local.dao.RecipeDao
import com.zybooks.foodamy.data.local.dao.RemoteKeysDao
import com.zybooks.foodamy.data.local.local_dto.RecipeDb
import com.zybooks.foodamy.data.local.local_dto.RemoteKeysEditor
import com.zybooks.foodamy.data.mapper.toLocalDto
import com.zybooks.foodamy.data.remote.network_api.RecipeApi

@OptIn(ExperimentalPagingApi::class)
class RecipeEditorRemoteMediator(
    private val recipeApi: RecipeApi,
    private val recipeDao: RecipeDao,
    private val remoteKeysDao: RemoteKeysDao
): RemoteMediator<Int, RecipeDb>() {


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, RecipeDb>
    ): MediatorResult {
        return try {
            val utils = RemoteMediatorUtils<Int, RecipeDb>(
                remoteKeysDao = remoteKeysDao,
                keyType = PagingKeyType.EDITOR_CHOICE
            )
            val currentPage =
                when (val keyData = utils.getPageKey(loadType, state)) {
                    is MediatorResult.Success -> {
                        return keyData
                    }
                    else -> {
                        keyData as Int
                    }
                }

            val response = recipeApi.getEditorsChoice(currentPage)
            val endOfPagination = response.data.isEmpty()

            val prevPage = if (currentPage == STARTING_INDEX) null else currentPage - 1
            val nextPage = if (endOfPagination) null else currentPage + 1

            if (loadType == LoadType.REFRESH) {
                remoteKeysDao.deleteEditorKeys()
                recipeDao.deleteEditorChoices()
            }
            val keys = response.data.map {
                RemoteKeysEditor(
                    id = it.id,
                    prev = prevPage,
                    next = nextPage
                )
            }
            remoteKeysDao.insertEditorRemoteKeys(keys)
            recipeDao.insertRecipes(response.data.map { it.toLocalDto() })
            MediatorResult.Success(endOfPaginationReached = endOfPagination)
        } catch (ex: Exception) {
            MediatorResult.Error(ex)
        }
    }

    companion object {
        private const val STARTING_INDEX = 1
    }
}