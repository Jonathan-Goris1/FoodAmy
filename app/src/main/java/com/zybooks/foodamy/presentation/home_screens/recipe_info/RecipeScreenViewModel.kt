package com.zybooks.foodamy.presentation.home_screens.recipe_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.zybooks.foodamy.domain.repository.RecipeRepository
import com.zybooks.foodamy.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeScreenViewModel @Inject constructor(
    private val repository: RecipeRepository
) : BaseViewModel() {
    var state by mutableStateOf(RecipeScreenState())
    private val tag: String = "RecipeScreenViewModel"

    init {
        getEditorsChoice()
    }



    private fun getEditorsChoice() {
        sendRequest(
            request = {
                repository.getEditorChoicePaging()
            },
            success = {

                    state = state.copy(
                        isLoading = false,
                        recipes = it,
                        error = null
                    )
                it.cachedIn(viewModelScope).collect() {

                }

            }
        )

    }
}
