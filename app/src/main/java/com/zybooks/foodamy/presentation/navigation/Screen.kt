package com.zybooks.foodamy.presentation.navigation


const val AUTHENTICATION_ROUTE = "authentication"
const val HOME_ROUTE = "home"
const val ROOT_ROUTE = "root"

sealed class Screen(val route: String){

    object Login : Screen("login")
    object ForgotPassword : Screen("forgot_password")
    object Register: Screen("register")
    object Home: Screen("home")

}


