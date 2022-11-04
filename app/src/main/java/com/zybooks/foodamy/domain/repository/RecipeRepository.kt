package com.zybooks.foodamy.domain.repository

import androidx.paging.PagingData
import com.zybooks.foodamy.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {


    suspend fun getEditorChoicePaging(): Flow<PagingData<Recipe>>

    suspend fun getEditorChoiceRecipes(page: Int = 1): List<Recipe>


    suspend fun getRecipeById(recipeId: Int, onlyRemote: Boolean): Recipe

}