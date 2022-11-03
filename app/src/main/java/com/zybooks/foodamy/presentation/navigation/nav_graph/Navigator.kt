package com.zybooks.foodamy.presentation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.presentation.home_screens.editor_choice_screen.AppScaffold
import com.zybooks.foodamy.presentation.navigation.AUTHENTICATION_ROUTE
import com.zybooks.foodamy.presentation.navigation.Screen

@Composable
fun Navigator(){
    val navController = rememberNavController()
    val navBarController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AUTHENTICATION_ROUTE

    ) {

        authNavGraph(navController = navController)

        //homeNavGraph(navController = navController)
        composable(
            route = Screen.AppScaffold.route,
            content = { AppScaffold() }
        )




    }

}
