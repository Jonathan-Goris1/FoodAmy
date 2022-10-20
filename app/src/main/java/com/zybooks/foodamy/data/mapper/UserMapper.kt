package com.zybooks.foodamy.data.mapper

import com.zybooks.foodamy.data.local.local_dto.ImageDb
import com.zybooks.foodamy.data.local.local_dto.UserDb
import com.zybooks.foodamy.data.remote.response.recipe.UserResponse
import com.zybooks.foodamy.domain.repository.model.User



fun UserDb.toDomainModel(): User = User(

    image = image.toDomainModel(),
    id =id,
    favoritesCount = followingCount,
    isFollowing = isFollowing,
    likesCount = likesCount,
    name = name,
    recipeCount = recipeCount,
    username = username,
    followedCount = followedCount,
    followingCount = followingCount
)

fun UserResponse.toDomainModel(): User = User(
    favoritesCount = favorites_count,
    followedCount = followed_count,
    image = image?.toDomainModel(),
    id =id,
    followingCount = following_count,
    isFollowing = is_following,
    likesCount = likes_count,
    name = name ?: "",
    recipeCount = recipe_count ?: 0,
    username = username
)

fun UserResponse.toLocalDto(): UserDb = UserDb(
    favoritesCount = favorites_count,
    followedCount = followed_count,
    image = image?.toLocalDto() ?: ImageDb.EMPTY,
    id =id,
    followingCount = following_count,
    isFollowing = is_following,
    likesCount = likes_count,
    name = name ?: "",
    recipeCount = recipe_count ?: 0,
    username = username,
)

fun User.toLocalDto(): UserDb = UserDb(
    favoritesCount = favoritesCount,
    followedCount = followedCount,
    image = image?.toLocalDto() ?: ImageDb.EMPTY,
    id =id,
    followingCount = followingCount,
    isFollowing = isFollowing,
    likesCount = likesCount,
    name = name ?: "",
    recipeCount = recipeCount ?: 0,
    username = username,
)

