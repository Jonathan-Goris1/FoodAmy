package com.zybooks.foodamy.presentation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zybooks.foodamy.presentation.home_screens.editor_choice_screen.RecipeHomeScreen
import com.zybooks.foodamy.presentation.home_screens.editor_choice_screen.recipe_detail_screen.RecipeDetailScreen
import com.zybooks.foodamy.presentation.home_screens.liked_info.LikedScreen
import com.zybooks.foodamy.presentation.home_screens.menu_info.MenuScreen
import com.zybooks.foodamy.presentation.home_screens.users_info.UsersScreen
import com.zybooks.foodamy.presentation.navigation.BottomNavItem
import com.zybooks.foodamy.presentation.navigation.Screen

@Composable

fun HomeHostNavGraph(navController: NavController){

    NavHost(
        navController = navController as NavHostController,
        startDestination = BottomNavItem.Recipe.screen_route,


    ) {

        composable(BottomNavItem.Recipe.screen_route) {
            RecipeHomeScreen(navController)
        }
        composable(BottomNavItem.Liked.screen_route) {
            LikedScreen(navController)
        }
        composable(BottomNavItem.Users.screen_route) {
            UsersScreen()
        }
        composable(BottomNavItem.Menu.screen_route) {
            MenuScreen()
        }

        composable(
            route = "${Screen.RecipeDetail.route}?recipeId={recipeId}",
            arguments = listOf(
                navArgument(name = "recipeId") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){ backStackEntry ->
            //TODO Make RecipeDetailsScreen and add it here
            RecipeDetailScreen(recipeID = backStackEntry.arguments?.getInt("recipeId"), navController = navController)
        }

    }
}