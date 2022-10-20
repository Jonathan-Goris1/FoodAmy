package com.zybooks.foodamy.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zybooks.foodamy.data.local.converters.CategoryConverter
import com.zybooks.foodamy.data.local.converters.ImageListConverter
import com.zybooks.foodamy.data.local.converters.RecipeListConverter
import com.zybooks.foodamy.data.local.converters.UserConverter
import com.zybooks.foodamy.data.local.dao.RecipeDao
import com.zybooks.foodamy.data.local.dao.RemoteKeysDao
import com.zybooks.foodamy.data.local.local_dto.*

@Database(
    entities = [
        RecipeDb::class,
        CategoryDb::class,
        CommentDb::class,
        RemoteKeyComment::class,
        UserDb::class,
        RemoteKeysEditor::class,
               ],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    UserConverter::class,
    CategoryConverter::class,
    RecipeListConverter::class,
    ImageListConverter::class,

)
abstract class AppDatabase: RoomDatabase() {
    abstract val recipeDao: RecipeDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}



