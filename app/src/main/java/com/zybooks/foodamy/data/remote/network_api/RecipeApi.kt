package com.zybooks.foodamy.data.remote.network_api

import com.zybooks.foodamy.data.remote.response.recipe.DataResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {


    @GET("recipe/{id}")
    suspend fun getRecipe(
        @Path("recipeID") recipeID: Int,
    ): DataResponse

    @GET("editor-choices")
    suspend fun getEditorsChoice(
        @Query("page") page: Int
    ): DataResponse
}