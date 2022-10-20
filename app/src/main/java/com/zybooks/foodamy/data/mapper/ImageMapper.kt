package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.ImageDb
import com.zybooks.foodamy.data.remote.response.recipe.ImageResponse
import com.zybooks.foodamy.domain.repository.model.Image

fun Image.toLocalDto(): ImageDb = ImageDb(
    height = height,
    url = url,
    width = width
)

fun ImageDb.toDomainModel(): Image = Image(
    height = height,
    url = url,
    width = width
)

fun ImageResponse.toDomainModel(): Image = Image(
    height = height,
    url = url,
    width = width
)

fun ImageResponse.toLocalDto(): ImageDb = ImageDb(
    width = width,
    height = height,
    url = url
)

