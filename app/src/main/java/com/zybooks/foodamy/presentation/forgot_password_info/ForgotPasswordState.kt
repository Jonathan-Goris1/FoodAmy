package com.zybooks.foodamy.presentation.forgot_password_info

data class ForgotPasswordState (
    val email: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
        )
