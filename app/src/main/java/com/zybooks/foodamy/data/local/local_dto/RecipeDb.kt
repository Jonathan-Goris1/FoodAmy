package com.zybooks.foodamy.data.local.local_dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeDb(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val category: CategoryDb,
    val comment_count: Int,
    val definition: String,
    val directions: String,
    val images: List<ImageDb>,
    val ingredients: String,
    val is_editor_choice: Boolean,
    val language: String,
    val like_count: Int,
    val number_of_favorite_count: Int,
    val number_of_person: NumberOfPersonDb,
    val time_of_recipe: TimeOfRecipeDb,
    val title: String,
    val user: UserDb,)



