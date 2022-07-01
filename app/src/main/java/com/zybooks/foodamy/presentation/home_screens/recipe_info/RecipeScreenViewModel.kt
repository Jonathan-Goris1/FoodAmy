package com.zybooks.foodamy.presentation.home_screens.recipe_info

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zybooks.foodamy.domain.repository.RecipeRepository
import com.zybooks.foodamy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeScreenViewModel@Inject constructor(
    private val repository: RecipeRepository
): ViewModel() {
    var state by mutableStateOf(RecipeScreenState())
    private val tag: String = "RecipeScreenViewModel"

init {
    getEditorsChoice()
}


    private fun getEditorsChoice() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            when (val getEditorsChoiceInfoResult = repository.getEditorsChoiceInfo()) {
                is Resource.Success -> {
                    state = state.copy(
                        recipes = getEditorsChoiceInfoResult.data?: emptyList(),
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = getEditorsChoiceInfoResult.message,

                    )
                    Log.d(tag, state.error.toString())

                }
                else -> {}
            }
            state = state.copy(isLoading = false)
        }
    }
}