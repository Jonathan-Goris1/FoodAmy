package com.zybooks.foodamy.domain.repository.model

data class User(
    val favorites_count: Int,
    val followed_count: Int,
    val following_count: Int,
    val id: Int,
    val image: Image?,
    val is_following: Boolean,
    val is_top_user_choice: Boolean,
    val is_trusted: Int,
    val language: String,
    val likes_count: Int,
    val name: String?,
    val recipe_count: Int?,
    val surname: String,
    val username: String,

)
