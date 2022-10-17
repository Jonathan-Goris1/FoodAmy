package com.zybooks.foodamy.data.local.local_dto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zybooks.foodamy.data.remote.response.recipe.ImageResponse

@Entity(tableName = "user")
data class UserDb(
    val cover: Any,
    val definition: String,
    //val facebook_url: Any,
    val favorites_count: Int,
    val followed_count: Int,
    val following_count: Int,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @Embedded
    val image: ImageResponse?,
    // instagram_url: Any,
    val is_following: Boolean,
    val is_top_user_choice: Boolean,
    val is_trusted: Int,
    val language: String,
    val likes_count: Int,
    val name: String?,
    val recipe_count: Int?,
    val surname: String,
   // val twitter_url: Any,
    val username: String,
    //val youtube_url: Any
)
