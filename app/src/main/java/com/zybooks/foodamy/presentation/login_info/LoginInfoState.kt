package com.zybooks.foodamy.presentation.login_info

import com.zybooks.foodamy.data.remote.response.LoginResponse

data class LoginInfoState(
    val login: LoginResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)