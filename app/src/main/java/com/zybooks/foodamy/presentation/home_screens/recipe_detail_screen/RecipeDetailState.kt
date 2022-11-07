package com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen

import androidx.paging.PagingData
import com.zybooks.foodamy.domain.model.Comment
import com.zybooks.foodamy.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class RecipeDetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val recipe: Recipe  = Recipe(),
    val comment: Comment = Comment()
)
