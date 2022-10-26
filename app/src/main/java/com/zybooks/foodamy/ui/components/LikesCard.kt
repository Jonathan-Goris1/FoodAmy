package com.zybooks.foodamy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun LikesCard(
    modifier: Modifier,
    Recipe: Recipe
){

    Card() {
        Column() {

            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(8.dp)
                    .clip(shape = RectangleShape),
                painter = rememberAsyncImagePainter(Recipe.category.image?.url),
                contentDescription = null,
            )
            
            Text(modifier = modifier.padding(8.dp),
                text = Recipe.title)

            Text(text = "${Recipe.commentCount} Comments ${Recipe.likeCount} Taste")

        }

    }
}