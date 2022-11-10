package com.zybooks.foodamy.data.remote.network_api

import com.zybooks.foodamy.data.remote.response.DataResponse
import com.zybooks.foodamy.data.remote.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("user/{user_id}")
    suspend fun getUserDetails(
        @Path("user_id") userId: Int
    ): UserResponse

    @GET("user/{user_id}/recipe")
    suspend fun getUserRecipes(
        @Path("user_id") userId: Int
    ): DataResponse

    @GET("user/2/like")
    suspend fun getUserLikes(
    ): DataResponse
}