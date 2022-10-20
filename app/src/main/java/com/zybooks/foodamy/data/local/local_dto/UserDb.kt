package com.zybooks.foodamy.data.local.local_dto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDb(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val username: String,
    val favoritesCount: Int,
    val followedCount: Int,
    val followingCount: Int,
    val isFollowing: Boolean,
    val likesCount: Int,
    val recipeCount: Int,
    @Embedded
    val image: ImageDb
)
