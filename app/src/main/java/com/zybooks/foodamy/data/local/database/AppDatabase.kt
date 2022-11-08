package com.zybooks.foodamy.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zybooks.foodamy.data.local.converters.Converters
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
       RemoteKeysCategory::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val recipeDao: RecipeDao
    abstract val remoteKeysDao: RemoteKeysDao
}



