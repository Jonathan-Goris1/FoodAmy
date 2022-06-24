package com.zybooks.foodamy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.presentation.auth_screens.forgot_password_info.ForgotPasswordScreen
import com.zybooks.foodamy.presentation.auth_screens.login_info.LoginInfoScreen
import com.zybooks.foodamy.presentation.auth_screens.register_info.RegisterInfoScreen
import com.zybooks.foodamy.presentation.home_screens.recipe_info.RecipeHomeScreen
import com.zybooks.foodamy.ui.theme.FoodAmyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAmyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            LoginInfoScreen(navController)
                        }
                        composable("register") {
                            RegisterInfoScreen()
                        }
                        composable("forgot password"){
                            ForgotPasswordScreen()
                        }

                        composable("home screen"){
                            RecipeHomeScreen()
                        }
                    }
                }
            }
        }
    }
}
