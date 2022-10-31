package com.zybooks.foodamy.presentation.home_screens.editor_choice_screen.recipe_detail_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import com.zybooks.foodamy.domain.repository.RecipeRepository
import com.zybooks.foodamy.presentation.base.BaseViewModel
import com.zybooks.foodamy.util.DeviceConnection
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val repository: RecipeRepository,
    savedStateHandle: SavedStateHandle,
    private val deviceConnection: DeviceConnection
) : BaseViewModel() {
    var state by mutableStateOf(RecipeDetailState())
    private val recipeID: Int = savedStateHandle.get<Int>("recipeId")!!

    init {
        recipeDetail()
    }


    private fun recipeDetail(){
        sendRequest(
            request = {
                repository.getRecipeById(recipeID, deviceConnection.isHasConnection() )
            },
            success = {
                state = state.copy(
                    isLoading = false,
                    recipe = it,
                    error = null
                )

            }
        )

    }
}