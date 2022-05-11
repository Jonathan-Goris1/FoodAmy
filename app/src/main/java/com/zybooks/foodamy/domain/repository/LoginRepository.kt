package com.zybooks.foodamy.domain.repository

import com.zybooks.foodamy.data.remote.response.LoginResponse
import com.zybooks.foodamy.util.Resource

interface LoginRepository {

    suspend fun postLoginInfo(
        email: String,
        password: String
    ): Resource<LoginResponse>
}