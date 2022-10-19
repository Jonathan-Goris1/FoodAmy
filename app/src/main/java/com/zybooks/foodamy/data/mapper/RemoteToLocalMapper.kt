package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.*
import com.zybooks.foodamy.data.remote.response.recipe.*

fun RecipeResponse.toLocalDb(): RecipeDb = RecipeDb(
    category = category.toLocalDb(),
    comment_count = comment_count,
    definition = definition,
    directions = directions,
    id = id,
    images = images.map { it.toLocalDb() },
    ingredients = ingredients,
    is_editor_choice = is_editor_choice,
    language = language,
    like_count = like_count,
    number_of_favorite_count = number_of_favorite_count,
    number_of_person = number_of_person.toLocalDb(),
    time_of_recipe = time_of_recipe.toLocalDb(),
    title = title,
    user = user.toLocalDb()


)


fun CategoryResponse.toLocalDb(): CategoryDb = CategoryDb(
    id = id,
    image = image?.toLocalDb(),
    name = name,
    language = ""

)

fun ImageResponse.toLocalDb(): ImageDb = ImageDb(
    height = height,
    key= key,
    order = order,
    url = url,
    width = width
)

fun NumberOfPersonResponse.toLocalDb(): NumberOfPersonDb = NumberOfPersonDb(
    id = id,
    text = text
)

fun TimeOfRecipeResponse.toLocalDb(): TimeOfRecipeDb = TimeOfRecipeDb(
    id = id,
    text = text
)

fun UserResponse.toLocalDb(): UserDb = UserDb(
    favorites_count = favorites_count,
    followed_count = followed_count,
    image = image?.toLocalDb(),
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
    username = username,
    cover = "",
    definition = ""
)