package com.zybooks.foodamy.domain.repository.model

import com.zybooks.foodamy.data.remote.response.recipe.PaginationResponse

data class Data(
    val recipe: List<Recipe>,
    val pagination: PaginationResponse
)
