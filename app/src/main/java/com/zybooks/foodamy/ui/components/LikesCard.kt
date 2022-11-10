package com.zybooks.foodamy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun LikesCard(
    recipe: Recipe
) {
    Card(
        modifier = Modifier.padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()

        ) {
            Image(
                modifier = Modifier
                    .width(180.dp)
                    .height(150.dp)
                    .clip(shape = RectangleShape),
                painter = rememberAsyncImagePainter(recipe.images[0].url),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )

            Text(
                modifier = Modifier.padding(8.dp),
                text = recipe.title,
            )

            Text(
                modifier = Modifier.padding(8.dp, 0.dp),
                text = "${recipe.commentCount} Comments ${recipe.likeCount} Likes",
                color = Color.DarkGray
            )


        }

    }
}