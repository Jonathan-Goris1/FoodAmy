package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.remote.response.recipe.*
import com.zybooks.foodamy.domain.repository.model.*

fun Recipe.toRemoteModel(): RecipeResponse = RecipeResponse(
    category = category.toRemoteModel(),
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
    number_of_person = number_of_person.toRemoteModel(),
    time_of_recipe = time_of_recipe.toRemoteModel(),
    title = title,
    user = user.toRemoteModel()
)

fun Category.toRemoteModel(): CategoryResponse = CategoryResponse(
    id = id,
    image = image?.toRemoteModel(),
    name = name,
)

fun Image.toRemoteModel(): ImageResponse = ImageResponse(
    height = height,
    key= key,
    order = order,
    url = url,
    width = width
)

fun NumberOfPerson.toRemoteModel(): NumberOfPersonResponse = NumberOfPersonResponse(
    id = id,
    text = text
)

fun TimeOfRecipe.toRemoteModel(): TimeOfRecipeResponse = TimeOfRecipeResponse(
    id = id,
    text = text
)

fun User.toRemoteModel(): UserResponse = UserResponse(
    favorites_count = favorites_count,
    followed_count = followed_count,
    image = image?.toRemoteModel(),
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