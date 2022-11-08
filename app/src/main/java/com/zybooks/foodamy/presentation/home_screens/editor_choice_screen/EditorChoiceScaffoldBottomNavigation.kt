package com.zybooks.foodamy.presentation.home_screens.editor_choice_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.R
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
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                containerColor = Color.Red,
                contentColor = Color.White
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_room_service_24), contentDescription = "")

            }
        },
        floatingActionButtonPosition = FabPosition.End


        ) { 
        HomeHostNavGraph(navController = navController)

    }
}