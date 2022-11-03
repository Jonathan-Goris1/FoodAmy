package com.zybooks.foodamy.presentation.navigation


const val AUTHENTICATION_ROUTE = "authentication"


sealed class Screen(val route: String) {

    object Login : Screen("login")
    object ForgotPassword : Screen("forgot_password")
    object Register : Screen("register")
    object AppScaffold : Screen("app_scaffold")



}


