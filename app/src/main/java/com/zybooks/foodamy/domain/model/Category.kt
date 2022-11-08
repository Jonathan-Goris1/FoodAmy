package com.zybooks.foodamy.domain.model

data class Category(
    val id: Int = 0,
    val image: Image? = Image(),
    val name: String = "",
    val recipes: List<Recipe>? = emptyList()
)
