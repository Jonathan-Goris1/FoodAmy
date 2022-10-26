package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.TimeOfRecipeDb
import com.zybooks.foodamy.data.remote.response.TimeOfRecipeResponse
import com.zybooks.foodamy.domain.model.TimeOfRecipe

fun TimeOfRecipe.toLocalModel(): TimeOfRecipeDb = TimeOfRecipeDb(
    id = id,
    text = text
)

fun TimeOfRecipeDb.toDomainModel(): TimeOfRecipe = TimeOfRecipe(
    id = id,
    text = text
)

fun TimeOfRecipeResponse.toDomainModel(): TimeOfRecipe = TimeOfRecipe(
    id = id,
    text = text
)


fun TimeOfRecipeResponse.toLocalDto(): TimeOfRecipeDb = TimeOfRecipeDb(
    id = id,
    text = text
)