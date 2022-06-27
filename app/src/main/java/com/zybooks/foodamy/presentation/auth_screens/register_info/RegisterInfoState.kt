package com.zybooks.foodamy.presentation.auth_screens.register_info

data class RegisterInfoState(
    val username: String = "",
    val email: String = "",
    val snackBarMessage: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error:String? = null,

)
