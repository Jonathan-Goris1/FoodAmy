package com.zybooks.foodamy.domain.repository

import com.zybooks.foodamy.data.remote.response.auth.AuthResponse
import com.zybooks.foodamy.util.Resource

interface AuthRepository {

    suspend fun postLoginInfo(
        email: String,
        password: String
    ): Resource<AuthResponse>

    suspend fun postRegisterInfo(
        email: String,
        password: String,
        username: String,
        name: String?,
        surname: String?,
        gender: String?,
        birthday: String?
    ): Resource<AuthResponse>

    suspend fun postForgotInfo(
        email: String
    ): Resource<AuthResponse>
}