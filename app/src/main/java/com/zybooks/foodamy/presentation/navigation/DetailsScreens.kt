package com.zybooks.foodamy.presentation.navigation

const val DETAIL_ROUTE = "detail_route"

sealed class DetailsScreens(val route: String) {

    object RecipeDetail : DetailsScreens("recipe_detail")
}