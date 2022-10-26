package com.zybooks.foodamy.domain.repository

import com.zybooks.foodamy.domain.model.Auth

interface AuthRepository {

    suspend fun login(
        email: String,
        password: String
    )

    suspend fun register(
        email: String,
        password: String,
        username: String
    ): Auth

    suspend fun forgot(
        email: String
    ): Auth
}