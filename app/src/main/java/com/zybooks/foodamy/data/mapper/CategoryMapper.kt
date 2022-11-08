package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.CategoryDb
import com.zybooks.foodamy.data.remote.response.CategoryResponse
import com.zybooks.foodamy.domain.model.Category

fun CategoryDb.toDomainModel(): Category = Category(
    id = id,
    image = image?.toDomainModel(),
    name = name,
    recipes = recipes?.map { it.toDomainModel() }

)

fun Category.toLocalModel(): CategoryDb = CategoryDb(
    id = id,
    image = image?.toLocalDto(),
    name = name,
    recipes = recipes?.map { it.toLocalModel() }
)
fun CategoryResponse.toDomainModel(): Category = Category(
    id = id,
    image = image?.toDomainModel(),
    name = name,
    recipes = recipes?.map { it.toDomainModel() }
)

fun CategoryResponse.toLocalDto(): CategoryDb = CategoryDb(
    id = id,
    image = image?.toLocalDto(),
    name = name,
    recipes = recipes?.map { it.toLocalDto() }
)
