package com.zybooks.foodamy.data.remote.network_api

import com.zybooks.foodamy.data.remote.response.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): AuthResponse

    @FormUrlEncoded
    @POST("auth/register")
    suspend fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String
    ): AuthResponse

    @FormUrlEncoded
    @POST("auth/forgot")
    suspend fun forgot(
        @Field("email") email: String
    ): AuthResponse




}