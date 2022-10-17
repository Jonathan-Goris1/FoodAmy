package com.zybooks.foodamy.data.remote.response.recipe

data class PaginationResponse(
    val current_page: Int,
    val first_item: Int,
    val last_item: Int,
    val last_page: Int,
    val per_page: Int,
    val total: Int
)