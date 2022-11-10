package com.zybooks.foodamy.presentation.home_screens.users_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.zybooks.foodamy.domain.repository.UserRepository
import com.zybooks.foodamy.domain.utils.DataStoreManager
import com.zybooks.foodamy.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserScreenViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val dataStoreManager: DataStoreManager,
): BaseViewModel() {

    var state by mutableStateOf(UserScreenState())

    init {
        getUserData()
    }

    private fun getUserData() = viewModelScope.launch {
            sendRequest(
                request = {
                    userRepository.getUserDetails(dataStoreManager.getUserId())
                          },
                success = {
                    getUserLikes()
                    getUserRecipes()
                    state = state.copy(
                        isLoading = false,
                        user = it,
                        error = null
                    )
                }
            )

    }

    private fun getUserRecipes() = viewModelScope.launch {
        sendRequest(
            request = {
                userRepository.getUSerRecipe(dataStoreManager.getUserId())
            },
            success = {
                state = state.copy(
                    isLoading = false,
                    userRecipe = it,
                    error = null
                )
            }
        )
    }

    private fun getUserLikes() = viewModelScope.launch {
        sendRequest(
            request = {
                userRepository.getUSerLikes()
            },
            success = {
                state = state.copy(
                    isLoading = false,
                    userLikes = it,
                    error = null
                )
            }
        )
    }


}