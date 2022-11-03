package com.zybooks.foodamy.presentation.home_screens.editor_choice_screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.presentation.navigation.nav_graph.HomeHostNavGraph
import com.zybooks.foodamy.ui.components.RecipeBottomNavigation


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppScaffold(
) {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            RecipeBottomNavigation(navController = navController)
        },
        scaffoldState = scaffoldState,


        ) { 
        HomeHostNavGraph(navController = navController)

    }
}