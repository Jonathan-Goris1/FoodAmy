package com.zybooks.foodamy.presentation.auth_screens.login_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.presentation.base.BaseViewModel
import com.zybooks.foodamy.util.Validations.validateEmail
import com.zybooks.foodamy.util.Validations.validatePassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginInfoViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel() {

    var state by mutableStateOf(LoginInfoState())

    fun updateEmail(email: String) {
        state = state.copy(email = email)
    }

    fun updatePassword(password: String) {
        state = state.copy(password = password)
    }

    fun login() {
        if (validateEmail(state.email) && validatePassword(state.password)) {
            sendRequest(
                loading = true,
                request = { authRepository.login(state.email, state.password) },
                success = {
                    state.copy(
                        isValid = true
                    )

                })
            }

    }
}