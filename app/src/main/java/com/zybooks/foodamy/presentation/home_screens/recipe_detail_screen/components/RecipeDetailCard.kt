package com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen.components

import androidx.compose.runtime.Composable
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun RecipeDetailCard(
    recipe: Recipe
) {
    
    RecipeDetailProfileSection( recipe = recipe )
    RecipeDetailStepsSection(recipe = recipe)
    RecipeDetailCommentSection(recipe = recipe)
    RecipeDetailSimilarRecipeSection(recipe = recipe)

}



