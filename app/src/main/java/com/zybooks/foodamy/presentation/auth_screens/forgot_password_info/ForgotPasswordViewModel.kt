package com.zybooks.foodamy.presentation.auth_screens.forgot_password_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.presentation.base.BaseViewModel
import com.zybooks.foodamy.util.Validations.validateEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel() {

    private val tag = "ForgotPasswordViewModel"
    var state by mutableStateOf(ForgotPasswordState())

    fun updateEmail(email: String){
        state = state.copy(email = email)
    }

    fun forgotPassword() {
        if (validateEmail(state.email)) {
            sendRequest(
                loading = true,
                request = { authRepository.forgot(state.email) },
                success = {

                })


        }
    }
}