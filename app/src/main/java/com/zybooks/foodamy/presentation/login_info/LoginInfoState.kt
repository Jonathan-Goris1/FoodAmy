package com.zybooks.foodamy.presentation.login_info

import com.zybooks.foodamy.data.remote.response.auth.AuthResponse

data class LoginInfoState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false

)