package com.zybooks.foodamy.presentation.home_screens.recipe_info

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.zybooks.foodamy.R
import com.zybooks.foodamy.presentation.navigation.Screen
import com.zybooks.foodamy.ui.components.RecipeCard
import com.zybooks.foodamy.ui.components.TextTabs
import com.zybooks.foodamy.ui.theme.DarkRed


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeHomeScreen(
    navController: NavController,
    viewModel: RecipeScreenViewModel = hiltViewModel()

) {
    val recipesItems = viewModel.state.recipes.collectAsLazyPagingItems()

    Scaffold(
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

        ) {

        Column {
            TextTabs()
            LazyColumn {
                items(recipesItems) { item ->
                    RecipeCard(Recipe = item, onClick = {
                        navController.navigate(Screen.RecipeDetail.route + "?recipeId=${item.id}")
                    })


                }

            }
        }


    }

}



