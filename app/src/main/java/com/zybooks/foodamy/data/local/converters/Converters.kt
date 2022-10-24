package com.zybooks.foodamy.data.local.converters

import androidx.room.TypeConverter
import com.zybooks.foodamy.data.local.local_dto.CategoryDb
import com.zybooks.foodamy.data.local.local_dto.ImageDb
import com.zybooks.foodamy.data.local.local_dto.RecipeDb
import com.zybooks.foodamy.data.local.local_dto.UserDb

class Converters {

    @TypeConverter
    fun categoryToJson(category: CategoryDb): String {
        return toJson<CategoryDb>(category)
    }

    @TypeConverter
    fun jsonToCategory(category: String): CategoryDb {
        return fromJson(category)
    }

    @TypeConverter
    fun imageListToJson(images: List<ImageDb>): String {
        return toJson<List<ImageDb>>(images)
    }

    @TypeConverter
    fun jsonToImageList(imageListSrc: String): List<ImageDb> {
        return fromJson(imageListSrc)
    }

    @TypeConverter
    fun recipeListToJson(recipes: List<RecipeDb>): String {
        return toJson<List<RecipeDb>>(recipes)
    }

    @TypeConverter
    fun jsonToRecipeList(recipes: String): List<RecipeDb> {
        return fromJson<List<RecipeDb>>(recipes)
    }

    @TypeConverter
    fun userToJson(user: UserDb): String {
        return toJson<UserDb>(user)
    }

    @TypeConverter
    fun jsonToUser(user: String): UserDb {
        return fromJson<UserDb>(user)
    }
}