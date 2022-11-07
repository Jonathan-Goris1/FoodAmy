package com.zybooks.foodamy.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zybooks.foodamy.data.local.local_dto.CommentDb
import com.zybooks.foodamy.data.local.local_dto.RecipeDb

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipes: List<RecipeDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(comments: List<CommentDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(comment: CommentDb)

    @Query("select * from recipes where is_editor_choice = 1 order by id desc")
    fun getEditorChoicesPaging(): PagingSource<Int, RecipeDb>

    @Query("select * from recipes where is_editor_choice =1")
    suspend fun getEditorChoices(): List<RecipeDb>

    @Query("select * from comments where recipe_id =:recipeId order by id desc")
    fun getRecipeCommentsPaging(recipeId: Int): PagingSource<Int, CommentDb>

    @Query("select * from comments where recipe_id =:recipeId")
    suspend fun getRecipeComments(recipeId: Int): List<CommentDb>

    @Query("delete from comments where id =:commentId")
    suspend fun deleteComment(commentId: Int)

    @Query("select * from comments where recipe_id =:recipeId order by id desc limit 1")
    suspend fun getFirstRecipeComments(recipeId: Int): CommentDb

    @Query("delete from comments")
    suspend fun deleteComments()

    @Query("DELETE FROM recipes")
    suspend fun clearRecipeListing()

    @Query("delete from recipes where is_editor_choice = 1")
    suspend fun deleteEditorChoices()

    @Query("select * from recipes where id =:recipeId ")
    suspend fun getRecipeDetails(recipeId: Int): RecipeDb



}