package com.zybooks.foodamy.presentation.home_screens.recipe_info

import androidx.paging.PagingData
import com.zybooks.foodamy.domain.repository.model.Recipe

data class RecipeScreenState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val recipes: PagingData<Recipe> = PagingData.empty()
)
