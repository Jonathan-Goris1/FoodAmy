package com.zybooks.foodamy.data.remote.network_api

import com.zybooks.foodamy.data.remote.response.recipe.DataResponse
import com.zybooks.foodamy.domain.repository.model.Data
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeApi {


    @GET("recipe/{id}")
    suspend fun getRecipe(
        @Path("recipeID") recipeID: Int,
    ): DataResponse

    @GET("editor-choices")
    suspend fun getEditorsChoice(): Data
}