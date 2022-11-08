package com.zybooks.foodamy.data.local.local_dto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "categories")
data class CategoryDb(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @Embedded
    val image: ImageDb?,
    //val main_category_id: Any,
    val name: String,
    val recipes: List<RecipeDb>?
)
