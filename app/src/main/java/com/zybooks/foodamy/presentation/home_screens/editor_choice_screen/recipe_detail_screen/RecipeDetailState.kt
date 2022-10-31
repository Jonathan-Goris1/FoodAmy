package com.zybooks.foodamy.presentation.home_screens.editor_choice_screen.recipe_detail_screen

import com.zybooks.foodamy.domain.model.Recipe

data class RecipeDetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val recipe: Recipe  = Recipe()
)
