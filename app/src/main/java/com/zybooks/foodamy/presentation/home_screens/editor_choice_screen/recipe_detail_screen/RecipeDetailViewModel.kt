package com.zybooks.foodamy.presentation.home_screens.editor_choice_screen.recipe_detail_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.zybooks.foodamy.domain.repository.RecipeRepository
import com.zybooks.foodamy.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val repository: RecipeRepository
) : BaseViewModel() {
    var state by mutableStateOf(RecipeDetailState())


    fun recipeDetail(){

    }
}