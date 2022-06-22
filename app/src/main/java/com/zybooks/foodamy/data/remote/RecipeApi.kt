package com.zybooks.foodamy.data.remote

import com.zybooks.foodamy.data.remote.response.recipe.RecipeResponse
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeApi {

    @FormUrlEncoded
    @GET("api/recipe/{id}")
    suspend fun getRecipe(
        @Path("recipeID") recipeID: Int,
    ): RecipeResponse
}