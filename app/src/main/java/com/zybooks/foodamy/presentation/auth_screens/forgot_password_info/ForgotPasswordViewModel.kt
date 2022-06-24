package com.zybooks.foodamy.presentation.auth_screens.forgot_password_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.util.Resource
import com.zybooks.foodamy.util.Validations.validateEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val tag = "ForgotPasswordViewModel"
    var state by mutableStateOf(ForgotPasswordState())

    fun updateEmail(email: String){
        state = state.copy(email = email)
    }


    fun forgotPassword() {
        if(validateEmail(state.email)){
            viewModelScope.launch {
                state = state.copy(isLoading = true)
                when(val forgotPasswordInfoResult =  repository.postForgotInfo(state.email)){
                    is Resource.Success -> {
                        state = state.copy(

                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false,
                            error = forgotPasswordInfoResult.message,
                        )

                    }
                    else -> {}
                }
                state = state.copy(isLoading = false)
            }
        }
    }
}