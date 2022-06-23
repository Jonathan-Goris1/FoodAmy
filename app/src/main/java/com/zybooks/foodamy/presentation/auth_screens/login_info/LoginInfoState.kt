package com.zybooks.foodamy.presentation.auth_screens.login_info

data class LoginInfoState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,


)