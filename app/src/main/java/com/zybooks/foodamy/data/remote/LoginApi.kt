package com.zybooks.foodamy.data.remote

import com.zybooks.foodamy.data.remote.response.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {

    @FormUrlEncoded
    @POST("api/auth/login")
    suspend fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse




}