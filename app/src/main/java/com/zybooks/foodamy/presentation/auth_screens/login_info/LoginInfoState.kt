package com.zybooks.foodamy.presentation.auth_screens.login_info

data class LoginInfoState(
    val email: String = "",
    val password: String = "",
    val snackBarMessage: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isValid: Boolean = false


)