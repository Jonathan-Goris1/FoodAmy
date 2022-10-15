package com.zybooks.foodamy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.zybooks.foodamy.R
import com.zybooks.foodamy.data.remote.response.recipe.Data

@Composable
fun LikedScreenCard(
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
                    painter = rememberAsyncImagePainter(Recipe.category.image?.url),
                    contentDescription = null,
                )

                Text(text = Recipe.category.name)

                Text(text = "See All")

            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color.LightGray,
                    thickness = 1.dp
                )
            }
        }

    }
}


@Preview
@Composable
fun LikedScreenCardPreview() {
    Card(
        modifier = Modifier
            .padding(0.dp, 8.dp)
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
                        .clip(shape = RectangleShape),
                    painter = painterResource(id = R.drawable.ic_baseline_face_24),
                    contentDescription = null,
                )

                Text(text = "ET")

                Text(text = "See All")

            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color.LightGray,
                    thickness = 1.dp
                )
            }
        }

    }

}