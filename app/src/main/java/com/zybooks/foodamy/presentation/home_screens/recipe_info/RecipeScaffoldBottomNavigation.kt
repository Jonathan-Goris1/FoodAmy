package com.zybooks.foodamy.presentation.home_screens.recipe_info

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.zybooks.foodamy.presentation.navigation.nav_graph.HomeHostNavGraph
import com.zybooks.foodamy.ui.components.RecipeBottomNavigation


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppScaffold(
    navController: NavController,

) {
    val scaffoldState = rememberScaffoldState()


    Scaffold(
        bottomBar = {
            RecipeBottomNavigation(navController = navController)
        },
        scaffoldState = scaffoldState,


        ) {

        HomeHostNavGraph(navController = navController)


    }

}