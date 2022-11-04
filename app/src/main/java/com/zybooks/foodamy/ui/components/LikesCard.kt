package com.zybooks.foodamy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun LikesCard(
    Recipe: Recipe
){

    Card(
        modifier = Modifier.padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {

            Image(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(300.dp)
                    .clip(shape = RectangleShape),
                painter = rememberAsyncImagePainter(Recipe.category.image?.url),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
            
            Text(modifier = Modifier.padding(8.dp),
                text = Recipe.title,
                fontSize = 12.sp
            )

            Box(modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxWidth(0.5F)){
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(8.dp),
                    text = "${Recipe.commentCount} Comments ${Recipe.likeCount} Taste"
                )
            }



        }

    }
}