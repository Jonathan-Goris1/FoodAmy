package com.zybooks.foodamy.data.remote

import com.zybooks.foodamy.data.remote.response.recipe.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeApi {


    @GET("recipe/{id}")
    suspend fun getRecipe(
        @Path("recipeID") recipeID: Int,
    ): RecipeResponse

    @GET("editor-choices")
    suspend fun getEditorsChoice(): RecipeResponse
}