package com.zybooks.foodamy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SocialListEntity::class],
    version = 1
)
abstract class SocialDatabase: RoomDatabase() {
    abstract val dao: SocialDao
}



