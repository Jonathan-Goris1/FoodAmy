package com.zybooks.foodamy.domain.model

import com.zybooks.foodamy.data.remote.response.PaginationResponse

data class Data(
    val data: List<Recipe>,
    val pagination: PaginationResponse
)
