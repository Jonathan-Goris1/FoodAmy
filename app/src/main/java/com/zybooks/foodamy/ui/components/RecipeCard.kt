package com.zybooks.foodamy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
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

        Column {

            Row(
                modifier = modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = modifier
                        .width(80.dp)
                        .height(80.dp)
                        .padding(8.dp)
                        .clip(shape = CircleShape),
                    painter = rememberAsyncImagePainter(Recipe.user.image?.url),
                    contentDescription = null,
                    )

                Column {
                    Text(text = Recipe.user.name ?: "")

                    Spacer(modifier = modifier.size(4.dp))

                    Text(text = "${Recipe.user.recipe_count} Recipes ${Recipe.user.following_count} Followers")


                }
            }

            Column {
                Row(modifier = modifier.fillMaxWidth()) {
                    Divider(
                        modifier = modifier
                            .fillMaxWidth(),
                        color = Color.LightGray,
                        thickness = 1.dp
                    )
                }


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
                        .padding(8.dp)
                        .clip(shape = RoundedCornerShape(4.dp)),
                    painter = rememberAsyncImagePainter(Recipe.category.image?.url),
                    contentDescription = null
                )

                Text(
                    modifier = modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                    text = "${Recipe.comment_count} Comments ${Recipe.like_count} Taste"
                )

            }

        }
    }
}

@Preview
@Composable
fun RecipeCardPreview() {
    Card(
        modifier = Modifier
            .padding(0.dp, 8.dp)
            .clickable(onClick = {})
    ) {
        Column {

            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .padding(8.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.ic_baseline_face_24),
                    contentDescription = null
                )

                Column {
                    Text(text = "Joseph")
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "0 Recipes 0 Followers")

                }
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color.LightGray,
                    thickness = 1.dp
                )
            }

            Text(
                modifier = Modifier.padding(8.dp),
                text = "Meatballs",
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                text = "Meat",
                fontSize = 12.sp
            )

            Image(
                modifier = Modifier
                    .width(400.dp)
                    .height(400.dp)
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
                painter = painterResource(id = R.drawable.ic_baseline_face_24),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                text = "0 Comments 0 Taste"
            )

        }

    }
}



