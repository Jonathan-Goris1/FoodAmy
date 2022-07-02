package com.zybooks.foodamy.presentation.home_screens.recipe_info

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.R
import com.zybooks.foodamy.ui.components.RecipeBottomNavigation
import com.zybooks.foodamy.ui.components.RecipeCard
import com.zybooks.foodamy.ui.theme.DarkRed


@Composable
fun RecipeHomeScreen(
    navController: NavController = rememberNavController(),
    viewModel: RecipeScreenViewModel = hiltViewModel()

) {
    val recipes = viewModel.state.recipes
    val TAG = "RecipeScreen"


    Scaffold(
        //TODO Work on creating the topBar tabs
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_foodamy___flat),
                            contentDescription = null
                        )

                    }

                },
                backgroundColor = DarkRed,
                actions = {
                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .size(30.dp, 30.dp),
                        onClick = { /* doSomething() */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_search_24),
                            tint = DarkRed,
                            contentDescription = "Search Recipe"
                        )
                    }


                }
            )
        },
        bottomBar = { RecipeBottomNavigation(navController = navController) }
    ) {

        Column {
            DoubleButtonScreen()
            Log.d(TAG, "RecipeHomeScreen: $recipes")

            LazyColumn {
                items(recipes) { recipe ->
                    RecipeCard(Recipe = recipe, onClick = {})
                    Log.d(TAG, "RecipeHomeScreen: $recipe")

                }

            }
        }
        


    }

}

//
@Composable
fun DoubleButtonScreen() {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier.weight(1.0f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            onClick = { /*TODO*/ }) {
            Text(text = "Editors Choice", color = Color.DarkGray)

        }
        Column {
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
                color = Color.DarkGray,
                thickness = 1.dp
            )

        }


        Button(
            modifier = Modifier.weight(1.0f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            onClick = { /*TODO*/ }) {
            Text(text = "Recently Added", color = Color.DarkGray)

        }


    }
}




@Preview
@Composable
fun RecipeHomeScreenPreview() {
    val navController = rememberNavController()
    RecipeHomeScreen(navController = navController)
}

