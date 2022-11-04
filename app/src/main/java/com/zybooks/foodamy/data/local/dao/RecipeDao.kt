package com.zybooks.foodamy.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zybooks.foodamy.data.local.local_dto.RecipeDb

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipes: List<RecipeDb>)

    @Query("select * from recipes where is_editor_choice = 1 order by id desc")
    fun getEditorChoicesPaging(): PagingSource<Int, RecipeDb>

    @Query("select * from recipes where is_editor_choice =1")
    suspend fun getEditorChoices(): List<RecipeDb>

    @Query("DELETE FROM recipes")
    suspend fun clearRecipeListing()

    @Query("delete from recipes where is_editor_choice = 1")
    suspend fun deleteEditorChoices()

    @Query("select * from recipes where id =:recipeId ")
    suspend fun getRecipeDetails(recipeId: Int): RecipeDb



}