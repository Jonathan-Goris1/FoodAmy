package com.zybooks.foodamy.presentation.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zybooks.foodamy.presentation.home_screens.liked_info.LikedScreen
import com.zybooks.foodamy.presentation.home_screens.menu_info.MenuScreen
import com.zybooks.foodamy.presentation.home_screens.recipe_info.RecipeHomeScreen
import com.zybooks.foodamy.presentation.home_screens.users_info.UsersScreen
import com.zybooks.foodamy.presentation.navigation.BottomNavItem
import com.zybooks.foodamy.presentation.navigation.HOME_ROUTE
import com.zybooks.foodamy.presentation.navigation.Screen


fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = Screen.Login.route,
        route = HOME_ROUTE
    ) {
        composable(BottomNavItem.Recipe.screen_route) {
            RecipeHomeScreen()
        }
        composable(BottomNavItem.Liked.screen_route) {
            LikedScreen()
        }
        composable(BottomNavItem.Users.screen_route) {
            UsersScreen()
        }
        composable(BottomNavItem.Menu.screen_route) {
            MenuScreen()
        }
    }
}