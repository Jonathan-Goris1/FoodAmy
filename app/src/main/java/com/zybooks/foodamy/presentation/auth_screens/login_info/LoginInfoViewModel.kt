package com.zybooks.foodamy.presentation.auth_screens.login_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.util.Resource
import com.zybooks.foodamy.util.Validations.validateEmail
import com.zybooks.foodamy.util.Validations.validatePassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginInfoViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    var state by mutableStateOf(LoginInfoState())

    fun updateEmail(email: String) {
        state = state.copy(email = email)
    }

    fun updatePassword(password: String) {
        state = state.copy(password = password)
    }

    fun login() {
        if (validateEmail(state.email) && validatePassword(state.password)) {
            viewModelScope.launch {
                state = state.copy(isLoading = true)
                when (val loginInfoResult = repository.postLoginInfo(state.email, state.password)) {
                    is Resource.Success -> {
                        state = state.copy(
                            snackBarMessage = "Login Successful",
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            snackBarMessage = "Invalid email or password",
                            isLoading = false,
                            error = loginInfoResult.message,
                        )

                    }
                    else -> {}
                }
                state = state.copy(isLoading = false)
            }
        } else{
            state = state.copy(snackBarMessage = "Please enter a correct email or password")
        }
    }
}