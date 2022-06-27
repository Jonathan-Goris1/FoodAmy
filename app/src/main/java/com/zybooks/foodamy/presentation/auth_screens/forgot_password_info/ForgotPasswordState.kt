package com.zybooks.foodamy.presentation.auth_screens.forgot_password_info

data class ForgotPasswordState (
    val email: String = "",
    val snackBarMessage: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
        )
