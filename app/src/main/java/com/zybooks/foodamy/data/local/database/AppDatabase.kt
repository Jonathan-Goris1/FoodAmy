package com.zybooks.foodamy.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zybooks.foodamy.data.local.dao.RecipeDao
import com.zybooks.foodamy.data.local.local_dto.RecipeDb

@Database(
    entities = [RecipeDb::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract val dao: RecipeDao
}



