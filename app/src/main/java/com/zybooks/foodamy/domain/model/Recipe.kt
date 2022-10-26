package com.zybooks.foodamy.domain.model

data class Recipe(
    val id: Int,
    val title: String,
    val definition: String,
    val ingredients: String,
    val directions: String,
    val difference: String,
    val isEditorChoice: Boolean,
    val isLiked: Boolean,
    val likeCount: Int,
    val commentCount: Int,
    val user: User,
    val timeOfRecipe: TimeOfRecipe,
    val numberOfPerson: NumberOfPerson,
    val category: Category,
    val images: List<Image>

)
