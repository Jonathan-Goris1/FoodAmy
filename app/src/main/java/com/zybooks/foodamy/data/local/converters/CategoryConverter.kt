package com.zybooks.foodamy.data.local.converters

import androidx.room.TypeConverter
import com.zybooks.foodamy.data.local.local_dto.CategoryDb

class CategoryConverter {

    @TypeConverter
    fun categoryToJson(category: CategoryDb): String {
        return toJson<CategoryDb>(category)
    }

    @TypeConverter
    fun jsonToCategory(category: String): CategoryDb {
        return fromJson<CategoryDb>(category)
    }
}