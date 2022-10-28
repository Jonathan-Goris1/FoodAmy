package com.zybooks.foodamy.data.remote.network_api

import com.zybooks.foodamy.data.remote.response.CategoryPagingResponse
import com.zybooks.foodamy.data.remote.response.DataResponse
import com.zybooks.foodamy.data.remote.response.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {


    @GET("recipe/{id}")
    suspend fun getRecipe(
        @Path("recipeID") recipeID: Int,
    ): RecipeResponse

    @GET("editor-choices")
    suspend fun getEditorsChoice(
        @Query("page") page: Int
    ): DataResponse

    @GET("category-recipes")
    suspend fun getCategoriesWithRecipes(
        @Query("page") page: Int
    ): CategoryPagingResponse
}