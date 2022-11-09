package com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.zybooks.foodamy.R
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun RecipeDetailProfileSection(
    recipe: Recipe
){
    Column {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(8.dp),
            painter = rememberAsyncImagePainter(recipe.images[0].url),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
            text = recipe.title,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
            text = recipe.category?.name ?: "",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
            text = recipe.timeOfRecipe.text,
            fontSize = 12.sp
        )

        Row(
            Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                IconButton(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Gray)
                        .size(30.dp, 30.dp),
                    onClick = { /* doSomething() */ }) {
                    Icon(
                        modifier = Modifier.size(20.dp, 20.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_chat_bubble_24),
                        tint = Color.White,
                        contentDescription = "Comments"
                    )
                }

                Spacer(modifier = Modifier.padding(0.dp, 8.dp))

                Text(
                    text = "${recipe.commentCount}",
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp

                )

            }

            Divider(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight(fraction = 0.6F)
                    .width(1.dp),
                color = Color.LightGray,
                thickness = 1.dp
            )

            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                IconButton(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Gray)
                        .size(30.dp, 30.dp),
                    onClick = { /* doSomething() */ }) {
                    Icon(
                        modifier = Modifier.size(20.dp, 20.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        tint = Color.White,
                        contentDescription = "Add Recipe"
                    )
                }

                Spacer(modifier = Modifier.padding(0.dp, 8.dp))

                Text(
                    text = "${recipe.user.recipeCount}",
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp

                )

            }

            Divider(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight(fraction = 0.6F)
                    .width(1.dp),
                color = Color.LightGray,
                thickness = 1.dp
            )

            Column(
                modifier = Modifier.padding(32.dp),
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
                        painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                        tint = Color.White,
                        contentDescription = "Likes"
                    )
                }

                Spacer(modifier = Modifier.padding(0.dp, 8.dp))

                Text(
                    text = "${recipe.likeCount}",
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp

                )

            }


        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.LightGray
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .padding(8.dp)
                    .clip(shape = CircleShape),
                painter = rememberAsyncImagePainter(recipe.user.image?.url),
                contentDescription = null,
            )

            Column {
                Text(text = recipe.user.name)

                Spacer(modifier = Modifier.size(4.dp))

                Text(text = "${recipe.user.recipeCount} Recipes ${recipe.user.followingCount} Followers")

            }

            Spacer(modifier = Modifier.size(64.dp))

            OutlinedButton(

                onClick = { /*TODO*/ },
                shape = CircleShape,
                border = BorderStroke(1.dp, color = Color.Red)

            ) {
                Text(
                    modifier = Modifier.padding(8.dp, 0.dp),
                    text = "Follow",
                    color = Color.Red
                )

            }

        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 5.dp,
            color = Color.LightGray
        )
    }


}

@Preview
@Composable
fun RecipeDetailCardPreview() {

    Card(
        modifier = Modifier.padding(0.dp, 8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
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
                text = "Meatball",
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(0.dp, 8.dp),
                text = "Meat",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "1 minute",
                fontSize = 12.sp
            )

            Row(
                Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.Gray)
                            .size(30.dp, 30.dp),
                        onClick = { /* doSomething() */ }) {
                        Icon(
                            modifier = Modifier.size(20.dp, 20.dp),
                            painter = painterResource(id = R.drawable.ic_baseline_chat_bubble_24),
                            tint = Color.White,
                            contentDescription = "Comments"
                        )
                    }

                    Spacer(modifier = Modifier.padding(0.dp, 8.dp))

                    Text(
                        text = "5",
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp

                    )

                }

                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp),
                    color = Color.LightGray,
                    thickness = 1.dp
                )

                Column(
                    modifier = Modifier.padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.Gray)
                            .size(30.dp, 30.dp),
                        onClick = { /* doSomething() */ }) {
                        Icon(
                            modifier = Modifier.size(20.dp, 20.dp),
                            painter = painterResource(id = R.drawable.ic_baseline_add_24),
                            tint = Color.White,
                            contentDescription = "Comments"
                        )
                    }

                    Spacer(modifier = Modifier.padding(0.dp, 8.dp))

                    Text(
                        text = "5",
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp

                    )

                }

                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp),
                    color = Color.LightGray,
                    thickness = 1.dp
                )

                Column(
                    modifier = Modifier.padding(32.dp),
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
                            painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                            tint = Color.White,
                            contentDescription = "Comments"
                        )
                    }

                    Spacer(modifier = Modifier.padding(0.dp, 8.dp))

                    Text(
                        text = "5",
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp

                    )

                }


            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .padding(8.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.ic_baseline_face_24),
                    contentDescription = null,
                )

                Column {
                    Text(text = "Jose")

                    Spacer(modifier = Modifier.size(4.dp))

                    Text(text = "0 Recipes 0 Followers")

                }

                Spacer(modifier = Modifier.size(64.dp))

                OutlinedButton(

                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    border = BorderStroke(1.dp, color = Color.Red)

                ) {
                    Text(
                        modifier = Modifier.padding(8.dp, 0.dp),
                        text = "Follow",
                        color = Color.Red
                    )

                }
            }
        }

    }

}