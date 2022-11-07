package com.zybooks.foodamy.data.utils

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.zybooks.foodamy.data.local.dao.RecipeDao
import com.zybooks.foodamy.data.local.dao.RemoteKeysDao
import com.zybooks.foodamy.data.local.local_dto.CommentDb
import com.zybooks.foodamy.data.local.local_dto.RemoteKeyComment
import com.zybooks.foodamy.data.mapper.toLocalDto
import com.zybooks.foodamy.data.remote.network_api.RecipeApi

@ExperimentalPagingApi
class CommentsRemoteMediator(
    private val recipeApi: RecipeApi,
    private val recipeDao: RecipeDao,
    private val remoteKeysDao: RemoteKeysDao,
    private val recipeId: Int
) : RemoteMediator<Int, CommentDb>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CommentDb>
    ): MediatorResult {
        return try {
            val utils = RemoteMediatorUtils<Int, CommentDb>(
                remoteKeysDao = remoteKeysDao,
                keyType = PagingKeyType.COMMENT
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

            val response = recipeApi.getRecipeComments(recipeId, currentPage)
            val endODPagination = response.data.isEmpty()

            val prevPage = if (currentPage == STARTING_INDEX) null else currentPage - 1
            val nextPage = if (endODPagination) null else currentPage + 1

            if (loadType == LoadType.REFRESH) {
                remoteKeysDao.deleteCommentsRemoteKeys()
                recipeDao.deleteComments()
            }
            val keys = response.data.map {
                RemoteKeyComment(
                    id = it.id,
                    prev = prevPage,
                    next = nextPage
                )
            }
            remoteKeysDao.insertCommentsRemoteKeys(keys)
            recipeDao.insertComments(response.data.map { it.toLocalDto(recipeId) })
            MediatorResult.Success(endOfPaginationReached = true)
        } catch (ex: Exception) {
            MediatorResult.Error(ex)
        }
    }

    companion object {
        private const val STARTING_INDEX = 1
    }
}