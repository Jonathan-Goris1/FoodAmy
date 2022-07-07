package com.zybooks.foodamy.presentation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zybooks.foodamy.presentation.home_screens.recipe_info.AppScaffold
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
            content = { AppScaffold(navController = navBarController) }
        )
        composable(
            route = "${Screen.RecipeDetail.route}?recipeId={recipeId}",
            arguments = listOf(
                navArgument(name = "recipeId") {
                    type = NavType.IntType
                }
            )
        ){
            //TODO Make RecipeDetailsScreen and add it here
        }



    }

}
