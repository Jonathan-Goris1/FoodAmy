package com.zybooks.foodamy.domain.model

data class User(
    val id: Int,
    val image: Image?,
    val name: String,
    val username: String,
    val favoritesCount: Int,
    val followedCount: Int,
    val followingCount: Int,
    val isFollowing: Boolean,
    val likesCount: Int,
    val recipeCount: Int

)
