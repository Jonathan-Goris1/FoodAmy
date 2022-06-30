package com.zybooks.foodamy.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.presentation.auth_screens.forgot_password_info.ForgotPasswordScreen
import com.zybooks.foodamy.presentation.auth_screens.login_info.LoginInfoScreen
import com.zybooks.foodamy.presentation.auth_screens.register_info.RegisterInfoScreen
import com.zybooks.foodamy.presentation.home_screens.recipe_info.RecipeHomeScreen

@Composable
fun Navigator(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route) {
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
            RecipeHomeScreen()
        }
    }
}

