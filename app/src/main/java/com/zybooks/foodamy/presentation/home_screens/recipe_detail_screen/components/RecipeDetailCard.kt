package com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun RecipeDetailCard(
    modifier: Modifier,
    recipe: Recipe
) {
    RecipeDetailProfileSection(modifier = modifier, recipe = recipe )

}



