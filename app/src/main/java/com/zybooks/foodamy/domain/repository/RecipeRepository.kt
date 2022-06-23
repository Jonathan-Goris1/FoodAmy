package com.zybooks.foodamy.domain.repository

import com.zybooks.foodamy.data.remote.response.recipe.RecipeResponse
import com.zybooks.foodamy.util.Resource

interface RecipeRepository {

    suspend fun getRecipeInfo(
        recipeID: Int
    ): Resource<RecipeResponse>

    suspend fun getEditorsChoiceInfo(): Resource<RecipeResponse>

}