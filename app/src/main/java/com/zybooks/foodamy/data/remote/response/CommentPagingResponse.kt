package com.zybooks.foodamy.data.remote.response

data class CommentPagingResponse(
    val data: List<CommentResponse>,
    val pagination: PaginationResponse
)
