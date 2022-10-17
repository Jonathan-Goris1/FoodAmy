package com.zybooks.foodamy.data.remote.response.recipe

data class CategoryResponse(
    val id: Int,
    val image: ImageResponse?,
    val language: String,
    val main_category_id: Any,
    val name: String
)