package com.zybooks.foodamy.data.remote.response.recipe

data class RecipeResponse(
    val category: CategoryResponse,
    val comment_count: Int,
    val definition: String,
    val difference: String,
    val directions: String,
    val id: Int,
    val images: List<ImageResponse>,
    val ingredients: String,
    val is_approved: Boolean,
    val is_editor_choice: Boolean,
    val is_favorited: Boolean,
    val is_liked:Boolean,
    val is_owner: Boolean,
    val language: String,
    val like_count: Int,
    val number_of_favorite_count: Int,
    val number_of_person: NumberOfPersonResponse,
    val time_of_recipe: TimeOfRecipeResponse,
    val title: String,
    val user: UserResponse,
    val view_count: Int?,
    val youtube_image: Any,
    val youtube_url: String
)


