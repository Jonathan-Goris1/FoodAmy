package com.zybooks.foodamy.data.local

import androidx.room.Entity

@Entity
data class SocialListEntity(
    val userImageURL: String,
    val userName: String?,
    val recipe_count: Int?,
    val following_count: Int,
    val recipeTitle: String,
    val categoryName: String,
    val categoryImageURL: String,
    val comment_count: Int,
    val like_count: Int
)


