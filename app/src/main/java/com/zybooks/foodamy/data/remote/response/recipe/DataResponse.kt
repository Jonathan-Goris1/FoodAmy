package com.zybooks.foodamy.data.remote.response.recipe

data class DataResponse(
    val data: List<RecipeResponse>,
    val pagination: PaginationResponse
)