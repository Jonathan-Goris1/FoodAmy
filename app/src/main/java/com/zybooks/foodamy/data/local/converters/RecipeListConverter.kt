package com.zybooks.foodamy.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.zybooks.foodamy.data.local.local_dto.RecipeDb

//@ProvidedTypeConverter
//class RecipeListConverter {
//
//    @TypeConverter
//    fun recipeListToJson(recipes: List<RecipeDb>): String {
//        return toJson<List<RecipeDb>>(recipes)
//    }
//
//    @TypeConverter
//    fun jsonToRecipeList(recipes: String): List<RecipeDb> {
//        return fromJson<List<RecipeDb>>(recipes)
//    }
//}