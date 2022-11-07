package com.zybooks.foodamy.data.remote.response

data class CommentResponse(
    val difference: String,
    val id: Int,
    val text: String,
    val user: UserResponse
)

