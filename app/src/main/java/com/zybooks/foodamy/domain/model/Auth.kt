package com.zybooks.foodamy.domain.model

data class Auth(
    var token: String,
    var user: User
)
