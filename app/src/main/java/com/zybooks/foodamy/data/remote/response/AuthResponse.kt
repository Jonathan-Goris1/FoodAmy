package com.zybooks.foodamy.data.remote.response

data class AuthResponse(
    var token: String,
    var user: UserResponse
)