package com.zybooks.foodamy.presentation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.presentation.navigation.AUTHENTICATION_ROUTE
import com.zybooks.foodamy.presentation.navigation.ROOT_ROUTE

@Composable
fun Navigator(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AUTHENTICATION_ROUTE,
        route = ROOT_ROUTE
    ) {

        authNavGraph(navController = navController)
        //TODO("Fix navigation issue, maybe find a different way of getting the navigation for bottomNavBar ")
        homeNavGraph(navController = navController)
    }
}
