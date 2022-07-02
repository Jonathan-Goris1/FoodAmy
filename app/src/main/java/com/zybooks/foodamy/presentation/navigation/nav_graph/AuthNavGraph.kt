package com.zybooks.foodamy.presentation.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zybooks.foodamy.presentation.auth_screens.forgot_password_info.ForgotPasswordScreen
import com.zybooks.foodamy.presentation.auth_screens.login_info.LoginInfoScreen
import com.zybooks.foodamy.presentation.auth_screens.register_info.RegisterInfoScreen
import com.zybooks.foodamy.presentation.home_screens.recipe_info.RecipeHomeScreen
import com.zybooks.foodamy.presentation.navigation.AUTHENTICATION_ROUTE
import com.zybooks.foodamy.presentation.navigation.Screen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Login.route,
        route = AUTHENTICATION_ROUTE
    ){
        composable(Screen.Login.route) {
            LoginInfoScreen(navController)
        }
        composable(Screen.Register.route) {
            RegisterInfoScreen(navController)
        }
        composable(Screen.ForgotPassword.route){
            ForgotPasswordScreen(navController)
        }
        composable(Screen.Home.route){
            RecipeHomeScreen(navController = navController)
        }

    }

}