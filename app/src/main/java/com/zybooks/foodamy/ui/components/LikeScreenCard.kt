package com.zybooks.foodamy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.zybooks.foodamy.R
import com.zybooks.foodamy.domain.model.Category
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun LikedScreenCard(
    modifier: Modifier = Modifier,
    category: Category?,
    likesData: List<Recipe>
) {
    Card(
        modifier = modifier
            .padding(0.dp, 8.dp)
    ) {
        Column {

            Row(
                modifier = modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(8.dp)
                        .clip(shape = RectangleShape),
                    painter = rememberAsyncImagePainter(category?.image?.url),
                    contentDescription = null,
                )

                Text(text = category?.name ?: "")

                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    textAlign = TextAlign.End,
                    text = "See All")

            }
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp),
                    color = Color.LightGray,
                    thickness = 1.dp
                )

            LazyRow {
                items(likesData) { favorite ->
                    LikesCard(recipe = favorite )

                }

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
        Column(modifier = Modifier
            .fillMaxWidth(),
        ) {

            Row(
                modifier = Modifier
                    .padding(8.dp, 0.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(8.dp)
                        .clip(shape = RectangleShape),
                    painter = painterResource(R.drawable.ic_baseline_face_24),
                    contentDescription = null,
                )

                Text(
                    text = "Meat"
                )


                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    textAlign = TextAlign.End,
                    text = "See All")

            }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp),
                    color = Color.LightGray,
                    thickness = 1.dp
                )

        }

    }

}


