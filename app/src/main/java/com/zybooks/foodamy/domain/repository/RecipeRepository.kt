package com.zybooks.foodamy.domain.repository

import com.zybooks.foodamy.data.remote.response.recipe.DataResponse
import com.zybooks.foodamy.domain.repository.model.Recipe
import com.zybooks.foodamy.util.Resource

interface RecipeRepository {

    suspend fun getRecipeInfo(
        recipeID: Int
    ): Resource<DataResponse>

    suspend fun getEditorsChoiceInfo(): Resource<List<Recipe>>

}