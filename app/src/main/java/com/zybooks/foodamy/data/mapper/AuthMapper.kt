package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.remote.response.AuthResponse
import com.zybooks.foodamy.domain.model.Auth

fun AuthResponse.toDomainModel(): Auth =
    Auth(
        token = token,
        user = user.toDomainModel()
    )