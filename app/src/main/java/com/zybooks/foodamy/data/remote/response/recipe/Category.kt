package com.zybooks.foodamy.data.remote.response.recipe

data class Category(
    val id: Int,
    val image: Image,
    val language: String,
    val main_category_id: Any,
    val name: String
)