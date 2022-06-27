package com.zybooks.foodamy.presentation.navigation

sealed class Screen(val route: String){
    object Login : Screen("login")
    object ForgotPassword : Screen("forgot_password")
    object Register: Screen("register")
    object Home: Screen("home")
}
