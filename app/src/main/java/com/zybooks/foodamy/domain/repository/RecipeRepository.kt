package com.zybooks.foodamy.domain.repository

import androidx.paging.PagingData
import com.zybooks.foodamy.data.remote.response.DataResponse
import com.zybooks.foodamy.domain.model.Recipe
import com.zybooks.foodamy.util.Resource
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    suspend fun getRecipeInfo(
        recipeID: Int
    ): Resource<DataResponse>

    suspend fun getEditorChoicePaging(): Flow<PagingData<Recipe>>

}