package com.zybooks.foodamy.presentation.navigation.nav_graph

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen.RecipeDetailScreen
import com.zybooks.foodamy.presentation.navigation.DETAIL_ROUTE
import com.zybooks.foodamy.presentation.navigation.DetailsScreens
import com.zybooks.foodamy.presentation.navigation.Screen


fun NavGraphBuilder.detailNavGraph(
    navController: NavController
){
    navigation(
        startDestination = Screen.Login.route,
        route = DETAIL_ROUTE
    ){
        composable(
            route = "${DetailsScreens.RecipeDetail.route}?recipeId={recipeId}",
            arguments = listOf(
                navArgument(name = "recipeId") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){ backStackEntry ->
            //TODO Make RecipeDetailsScreen and add it here
            RecipeDetailScreen(recipeID = backStackEntry.arguments?.getInt("recipeId"), onNavigateBackToEditorChoice = {navController.popBackStack()})
        }
    }
}