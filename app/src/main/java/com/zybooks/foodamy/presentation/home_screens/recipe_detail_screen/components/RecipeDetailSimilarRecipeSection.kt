package com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zybooks.foodamy.domain.model.Recipe
import com.zybooks.foodamy.ui.components.LikesCard

@Composable
fun RecipeDetailSimilarRecipeSection(
    recipe: Recipe
) {
    Column() {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Similar Recipe"
        )

        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.LightGray
        )

    }
    LikesCard(recipe = recipe)
}