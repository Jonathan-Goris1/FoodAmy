package com.zybooks.foodamy.presentation.register_info

data class RegisterInfoState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error:String? = null,
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false
)
