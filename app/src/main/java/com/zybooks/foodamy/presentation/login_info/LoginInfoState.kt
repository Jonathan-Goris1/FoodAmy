package com.zybooks.foodamy.presentation.login_info

import com.zybooks.foodamy.data.remote.response.auth.AuthResponse

data class LoginInfoState(
    val login: AuthResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)