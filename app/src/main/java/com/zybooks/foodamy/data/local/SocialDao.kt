package com.zybooks.foodamy.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SocialDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(
        socialListEntity: SocialListEntity
    )

    @Query("DELETE FROM socialListEntity")
    suspend fun clearRecipeListing()

    @Query(" SELECT * From socialListEntity ")
    suspend fun searchRecipeListing(): List<SocialListEntity>

}