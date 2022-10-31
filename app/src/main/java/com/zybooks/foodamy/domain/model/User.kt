package com.zybooks.foodamy.domain.model

data class User(
    val id: Int = 0,
    val image: Image? = Image(),
    val name: String = "",
    val username: String = "",
    val favoritesCount: Int = 0,
    val followedCount: Int = 0,
    val followingCount: Int = 0,
    val isFollowing: Boolean = false,
    val likesCount: Int = 0,
    val recipeCount: Int = 0

)
