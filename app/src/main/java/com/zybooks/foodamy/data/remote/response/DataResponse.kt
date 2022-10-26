package com.zybooks.foodamy.data.remote.response

data class DataResponse(
    val data: List<RecipeResponse>,
    val pagination: PaginationResponse
)