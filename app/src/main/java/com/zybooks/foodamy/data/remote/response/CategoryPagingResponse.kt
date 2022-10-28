package com.zybooks.foodamy.data.remote.response

data class CategoryPagingResponse(
    val data: List<CategoryResponse>,
    val pagination: PaginationResponse
)
