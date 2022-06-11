package com.zybooks.foodamy.data.remote

import com.zybooks.foodamy.data.remote.response.auth.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("api/auth/login")
    suspend fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): AuthResponse

    @FormUrlEncoded
    @POST("api/auth/register")
    suspend fun postRegister(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String,
        @Field("name") name: String?,
        @Field("surname") surname: String?,
        @Field("gender") gender: String?,
        @Field("birthday") birthday: String?
    ): AuthResponse




}