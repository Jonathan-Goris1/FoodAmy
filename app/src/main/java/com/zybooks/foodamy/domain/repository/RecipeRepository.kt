package com.zybooks.foodamy.domain.repository

import androidx.paging.PagingData
import com.zybooks.foodamy.domain.model.Category
import com.zybooks.foodamy.domain.model.Comment
import com.zybooks.foodamy.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {


    suspend fun getEditorChoicePaging(): Flow<PagingData<Recipe>>

    suspend fun getEditorChoiceRecipes(page: Int = 1): List<Recipe>


    suspend fun getRecipeById(recipeId: Int, onlyRemote: Boolean): Recipe

    suspend fun getRecipeCommentsPaging(recipeId: Int): Flow<PagingData<Comment>>

    suspend fun getFirstComment(recipeId: Int): Comment

    suspend fun getCategoriesPaging(): Flow<PagingData<Category>>

}