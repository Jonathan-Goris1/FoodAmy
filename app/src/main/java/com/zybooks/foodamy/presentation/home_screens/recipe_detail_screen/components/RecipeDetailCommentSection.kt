package com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.zybooks.foodamy.domain.model.Comment
import com.zybooks.foodamy.domain.model.Recipe

@Composable
fun RecipeDetailCommentSection(
    comment: Comment
) {

    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterStart),
                    text = "COMMENTS"
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
            modifier = Modifier.padding(8.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .padding(8.dp)
                    .clip(shape = CircleShape),
                painter = rememberAsyncImagePainter(comment.user.image?.url),

                contentDescription = null,
            )

            Column {
                Text(text = comment.user.name)

                Spacer(modifier = Modifier.size(4.dp))

                Text(text = "${comment.user.recipeCount} Recipes ${comment.user.followingCount} Followers")


            }
        }
        Text(
            modifier = Modifier.padding(16.dp, 0.dp),
            text = comment.difference
        )

        Text(
            modifier = Modifier.padding(8.dp, 8.dp),
            text = comment.text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold

        )


        Box(modifier = Modifier.fillMaxWidth().background(color = Color.LightGray).padding(8.dp)){

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "ADD COMMENT"
                )

            }
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}