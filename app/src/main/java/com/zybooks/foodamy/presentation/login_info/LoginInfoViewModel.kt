package com.zybooks.foodamy.presentation.login_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: AuthRepository
) : ViewModel() {

    var state by mutableStateOf(LoginInfoState())

    fun updateEmail(email: String){
        state.login?.user?.copy(email = email)
    }

    fun updatePassword(password: String){

    }


    init {
        viewModelScope.launch {
            val email = savedStateHandle.get<String>("email") ?: return@launch
            val password = savedStateHandle.get<String>("password") ?: return@launch
            state = state.copy(isLoading = true)
            val loginInfoResult = async { repository.postLoginInfo(email, password)}
            when(val result = loginInfoResult.await()){
                is Resource.Success -> {
                    state = state.copy(
                        login = result.data,
                        isLoading = false,
                        error = null
                    )

                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                        login = null
                    )

                }
                else -> Unit
            }


        }
    }
}