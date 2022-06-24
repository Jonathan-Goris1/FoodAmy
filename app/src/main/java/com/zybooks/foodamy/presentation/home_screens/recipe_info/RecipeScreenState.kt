package com.zybooks.foodamy.presentation.home_screens.recipe_info

import com.zybooks.foodamy.data.remote.response.recipe.Data

data class RecipeScreenState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val recipes: List<Data>? = emptyList(),
)
