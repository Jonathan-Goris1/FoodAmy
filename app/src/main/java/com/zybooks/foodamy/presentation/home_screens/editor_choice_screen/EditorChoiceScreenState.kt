package com.zybooks.foodamy.presentation.home_screens.editor_choice_screen

import androidx.paging.PagingData
import com.zybooks.foodamy.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class EditorChoiceScreenState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val recipes: Flow<PagingData<Recipe>> = emptyFlow()
)
