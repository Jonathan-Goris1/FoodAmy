package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.*
import com.zybooks.foodamy.domain.repository.model.*

fun Recipe.toLocalModel(): RecipeDb = RecipeDb(
    category = category.toLocalModel(),
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
    number_of_person = number_of_person.toLocalModel(),
    time_of_recipe = time_of_recipe.toLocalModel(),
    title = title,
    user = user.toLocalModel()
)

fun Category.toLocalModel(): CategoryDb = CategoryDb(
    id = id,
    image = image?.toLocalModel(),
    name = name,
)

fun Image.toLocalModel(): ImageDb  = ImageDb(
    height = height,
    key= key,
    order = order,
    url = url,
    width = width
)

fun NumberOfPerson.toLocalModel(): NumberOfPersonDb = NumberOfPersonDb(
    id = id,
    text = text
)

fun TimeOfRecipe.toLocalModel(): TimeOfRecipeDb = TimeOfRecipeDb(
    id = id,
    text = text
)

fun User.toLocalModel(): UserDb = UserDb(
    favorites_count = favorites_count,
    followed_count = followed_count,
    image = image?.toLocalModel(),
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