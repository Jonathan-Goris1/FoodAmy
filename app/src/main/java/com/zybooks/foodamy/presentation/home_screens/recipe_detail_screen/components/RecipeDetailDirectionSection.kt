package com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zybooks.foodamy.R
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun RecipeDetailDirectionSection(
    recipe: Recipe
){
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterStart),
                    text = "DIRECTIONS"
                )

                Column(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.LightGray)
                            .size(30.dp, 30.dp),
                        onClick = { /* doSomething() */ }) {
                        Icon(
                            modifier = Modifier.size(20.dp, 20.dp),
                            painter = painterResource(id = R.drawable.ic_baseline_timer_24),
                            tint = Color.White,
                            contentDescription = "Comments"
                        )
                    }

                    Spacer(modifier = Modifier.size(4.dp))

                    Text(text = recipe.timeOfRecipe.text)

                }
            }

        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )

        Text(text = recipe.directions)

        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 5.dp,
            color = Color.LightGray
        )
    }
}