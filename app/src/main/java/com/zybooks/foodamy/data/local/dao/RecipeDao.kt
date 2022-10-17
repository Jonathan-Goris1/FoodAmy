package com.zybooks.foodamy.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zybooks.foodamy.data.local.local_dto.RecipeDb
import com.zybooks.foodamy.util.Resource

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(
        recipes: List<RecipeDb>
    )

    @Query("DELETE FROM recipes")
    suspend fun clearRecipeListing()

    @Query("SELECT * FROM recipes ")
    suspend fun getRecipeListing(): Resource<List<RecipeDb>>

}