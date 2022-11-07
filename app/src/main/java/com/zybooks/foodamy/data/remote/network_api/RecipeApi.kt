package com.zybooks.foodamy.data.remote.network_api

import com.zybooks.foodamy.data.remote.response.CategoryPagingResponse
import com.zybooks.foodamy.data.remote.response.CommentPagingResponse
import com.zybooks.foodamy.data.remote.response.DataResponse
import com.zybooks.foodamy.data.remote.response.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {


    @GET("recipe/{recipe_id}")
    suspend fun getRecipe(
        @Path("recipe_id") recipeID: Int,
    ): RecipeResponse

    @GET("editor-choices")
    suspend fun getEditorsChoice(
        @Query("page") page: Int
    ): DataResponse

    @GET("category-recipes")
    suspend fun getCategoriesWithRecipes(
        @Query("page") page: Int
    ): CategoryPagingResponse

    @GET("recipe/{recipe_id}/comment")
    suspend fun getRecipeComments(
        @Path("recipe_id") recipeId: Int,
        @Query("page") page: Int
    ): CommentPagingResponse
}