package com.zybooks.foodamy.presentation.home_screens.users_info.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.zybooks.foodamy.R
import com.zybooks.foodamy.domain.model.User

@Composable
fun UserScreenProfileSection(
    user: User
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .padding(8.dp)

                .clip(shape = CircleShape),
            painter = rememberAsyncImagePainter(
                user.image?.url ?: R.drawable.ic_baseline_face_24
            ),
            contentDescription = null,
        )

        Text(
            modifier = Modifier
                .padding(8.dp),

            text = user.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "${user.followingCount} Following  ${user.followedCount} Followers",
            fontSize = 20.sp,
        )


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.align(Alignment.CenterStart),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Recipes")
                        Text(
                            text = "${user.recipeCount}",
                            textAlign = TextAlign.Center
                        )

                    }

                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Favorites")
                        Text(text = "${user.favoritesCount}")

                    }

                    Column(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Likes")
                        Text(text = "${user.likesCount}")

                    }
                }
            }

        }


    }
}