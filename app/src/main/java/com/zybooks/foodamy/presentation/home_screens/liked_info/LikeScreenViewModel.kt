package com.zybooks.foodamy.presentation.home_screens.liked_info

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
class LikeScreenViewModel @Inject constructor(
    private val repository: RecipeRepository
) : BaseViewModel() {
    var state by mutableStateOf(LikedScreenState())

    init {
        getFavorites()
    }



    private fun getFavorites() {
        sendRequest(
            request = {
                repository.getCategoriesPaging()
            },
            success = {
                state = state.copy(
                    isLoading = false,
                    recipes = it,
                    error = null
                )

                it.cachedIn(viewModelScope)

            }
        )

    }
}