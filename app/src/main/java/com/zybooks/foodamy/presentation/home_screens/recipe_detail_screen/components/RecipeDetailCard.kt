package com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen.components

import androidx.compose.runtime.Composable
import com.zybooks.foodamy.domain.model.Comment
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun RecipeDetailCard(
    recipe: Recipe,
    comment: Comment

) {
    
    RecipeDetailProfileSection( recipe = recipe )
    RecipeDetailIngredientsSection(recipe = recipe)
    RecipeDetailDirectionSection(recipe = recipe)
    RecipeDetailCommentSection(comment = comment)
    RecipeDetailSimilarRecipeSection(recipe = recipe)

}



