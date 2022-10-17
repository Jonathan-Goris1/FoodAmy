package com.zybooks.foodamy.data.remote.response.recipe

data class DataResponse(
    val recipe: List<RecipeResponse>,
    val pagination: PaginationResponse
)