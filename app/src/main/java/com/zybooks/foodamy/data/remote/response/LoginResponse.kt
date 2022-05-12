package com.zybooks.foodamy.data.remote.response

data class LoginResponse(
    val token: String,
    val user: User
)