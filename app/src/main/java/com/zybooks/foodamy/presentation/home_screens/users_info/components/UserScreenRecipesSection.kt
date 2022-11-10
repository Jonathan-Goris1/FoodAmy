package com.zybooks.foodamy.presentation.home_screens.users_info.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.foodamy.domain.model.Recipe
import com.zybooks.foodamy.ui.components.LikesCard

@Composable
fun UserScreenRecipesSection(
    recipes: List<Recipe>
){
    Column {

        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "Recipes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )

        LazyRow {
            items(recipes) { recipe ->
                LikesCard(recipe = recipe)

            }
        }
    }
}