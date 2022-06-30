package com.zybooks.foodamy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.foodamy.R
import com.zybooks.foodamy.data.remote.response.recipe.Data

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    Recipe: Data,
    onClick: () -> Unit

) {
    Card(
        modifier = modifier
            .padding(0.dp, 8.dp)
            .clickable(onClick = onClick)
    ) {
        Row(modifier = modifier.padding(8.dp)) {
            Image(
                modifier = modifier
                    .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_baseline_face_24),
                contentDescription = null
            )

            Column {
                Text(text = Recipe.user.name)
                Row {
                    Text(text = "${Recipe.user.recipe_count} Recipes ${Recipe.user.following_count} Followers")
                }


            }
        }

        Column {
            Divider(
                modifier = modifier
                    .fillMaxWidth(),
                color = Color.LightGray,
                thickness = 1.dp
            )

            Text(
                modifier = modifier.padding(8.dp),
                text = Recipe.title,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                text = Recipe.category.name,
                fontSize = 12.sp
            )

            Image(
                modifier = modifier
                    .width(400.dp)
                    .height(400.dp)
                    .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_baseline_face_24),
                contentDescription = null
            )

            Row {
                Text(
                    modifier = modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                    text = "${Recipe.comment_count} Comments ${Recipe.like_count} Taste"
                )

            }


        }
    }
}