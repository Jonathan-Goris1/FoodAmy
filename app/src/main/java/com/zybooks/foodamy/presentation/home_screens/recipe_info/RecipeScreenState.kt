package com.zybooks.foodamy.presentation.home_screens.recipe_info

import com.zybooks.foodamy.domain.repository.model.Recipe

data class RecipeScreenState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val recipes: List<Recipe> = emptyList()
)
