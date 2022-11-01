package com.zybooks.foodamy.presentation.home_screens.editor_choice_screen.recipe_detail_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun RecipeDetailCard(
    modifier: Modifier,
    recipe: Recipe
) {
    Card(
        modifier = modifier.padding(0.dp, 8.dp)
    ) {
       RecipeDetailProfileSection(modifier = modifier, recipe = recipe )
    }
}



