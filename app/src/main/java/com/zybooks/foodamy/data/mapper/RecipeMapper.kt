package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.RecipeDb
import com.zybooks.foodamy.data.remote.response.RecipeResponse
import com.zybooks.foodamy.domain.model.Recipe

fun RecipeDb.toDomainModel(): Recipe = Recipe(
    category = category?.toDomainModel(),
    commentCount = commentCount,
    definition = definition,
    directions = directions,
    id = id,
    images = image.map { it.toDomainModel() },
    ingredients = ingredients,
    isEditorChoice = isEditorChoice,
    likeCount = likeCount,
    numberOfPerson = numberOfPerson.toDomainModel(),
    timeOfRecipe = timeOfRecipe.toDomainModel(),
    title = title ?: "",
    user = user.toDomainModel(),
    difference = difference,
    isLiked = isLiked


)

fun RecipeResponse.toDomainModel(): Recipe = Recipe(
    category = category.toDomainModel(),
    commentCount = comment_count,
    definition = definition,
    directions = directions,
    id = id,
    images = images.map { it.toDomainModel() },
    ingredients = ingredients,
    isEditorChoice = is_editor_choice,
    likeCount = like_count,
    numberOfPerson = number_of_person.toDomainModel(),
    timeOfRecipe = time_of_recipe.toDomainModel(),
    title = title,
    user = user.toDomainModel(),
    isLiked = is_approved,
    difference = difference


)

fun Recipe.toLocalModel(): RecipeDb = RecipeDb(
    category = category?.toLocalModel(),
    commentCount = commentCount,
    definition = definition,
    directions = directions,
    id = id,
    image = images.map { it.toLocalDto() },
    ingredients = ingredients,
    isEditorChoice = isEditorChoice,
    likeCount = likeCount,
    numberOfPerson = numberOfPerson.toLocalModel(),
    timeOfRecipe = timeOfRecipe.toLocalModel(),
    title = title,
    difference = difference,
    isLiked = isLiked,
    user = user.toLocalDto()
)

fun RecipeResponse.toLocalDto(isLastAdded: Boolean = false): RecipeDb = RecipeDb(
    id = id,
    title = title,
    definition = definition,
    ingredients = ingredients,
    directions = directions,
    category = category.toLocalDto(),
    commentCount = comment_count,
    image = images.map { it.toLocalDto() },
    isEditorChoice = is_editor_choice,
    likeCount = like_count,
    numberOfPerson = number_of_person.toLocalDto(),
    timeOfRecipe = time_of_recipe.toLocalDto(),
    user = user.toLocalDto(),
    difference = difference,
    isLiked = is_liked

)
