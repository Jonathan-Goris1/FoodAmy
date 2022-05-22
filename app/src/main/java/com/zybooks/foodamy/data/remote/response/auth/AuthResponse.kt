package com.zybooks.foodamy.data.remote.response.auth

data class AuthResponse(
    var token: String,
    var user: User
)