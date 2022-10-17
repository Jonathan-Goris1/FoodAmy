package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.*
import com.zybooks.foodamy.domain.repository.model.*

fun RecipeDb.toDomainModel(): Recipe = Recipe(
    category = this.category,
    comment_count = comment_count,
    definition = definition,
    directions = directions,
    id = id,
    images = images,
    ingredients = ingredients,
    is_editor_choice = is_editor_choice,
    language = language,
    like_count = like_count,
    number_of_favorite_count = number_of_favorite_count,
    number_of_person = number_of_person,
    time_of_recipe = time_of_recipe,
    title = title,
    user = user


)


fun CategoryDb.toDomainModel() = Category(
    id = id,
    image = image,
    name = name

)

fun ImageDb.toDomainModel() = Image(
    height = height,
    key= key,
    order = order,
    url = url,
    width = width
)

fun NumberOfPersonDb.toDomainModel() = NumberOfPerson(
    id = id,
    text = text
)

fun TimeOfRecipeDb.toDomainModel() = TimeOfRecipe(
    id = id,
    text = text
)

fun UserDb.toDomainModel() = User(
    favorites_count = favorites_count,
    followed_count = followed_count,
    image = image,
    id =id,
    following_count = following_count,
    is_following = is_following,
    is_top_user_choice = is_top_user_choice,
    is_trusted = is_trusted,
    language = language,
    likes_count = likes_count,
    name = name,
    recipe_count = recipe_count,
    surname = surname,
    username = username
)

