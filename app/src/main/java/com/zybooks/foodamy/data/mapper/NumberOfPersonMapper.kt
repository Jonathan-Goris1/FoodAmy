package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.NumberOfPersonDb
import com.zybooks.foodamy.data.remote.response.recipe.NumberOfPersonResponse
import com.zybooks.foodamy.domain.repository.model.NumberOfPerson

fun NumberOfPerson.toLocalModel(): NumberOfPersonDb = NumberOfPersonDb(
    id = id,
    text = text
)

fun NumberOfPersonDb.toDomainModel(): NumberOfPerson = NumberOfPerson(
    id = id,
    text = text
)

fun NumberOfPersonResponse.toDomainModel(): NumberOfPerson = NumberOfPerson(
    id = id,
    text = text
)

fun NumberOfPersonResponse.toLocalDto(): NumberOfPersonDb = NumberOfPersonDb(
    id = id,
    text = text
)
