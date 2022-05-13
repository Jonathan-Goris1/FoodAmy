package com.zybooks.foodamy.data.remote.response.auth

data class AuthResponse(
    val token: String,
    val user: User
)