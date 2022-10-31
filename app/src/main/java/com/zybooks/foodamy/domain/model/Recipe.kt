package com.zybooks.foodamy.domain.model

data class Recipe(
    val id: Int = 0,
    val title: String = "",
    val definition: String = "",
    val ingredients: String = "",
    val directions: String = "",
    val difference: String = "",
    val isEditorChoice: Boolean = false,
    val isLiked: Boolean = false,
    val likeCount: Int = 0,
    val commentCount: Int = 0,
    val user: User = User(),
    val timeOfRecipe: TimeOfRecipe = TimeOfRecipe(),
    val numberOfPerson: NumberOfPerson = NumberOfPerson(),
    val category: Category = Category(),
    val images: List<Image> = emptyList()

)
