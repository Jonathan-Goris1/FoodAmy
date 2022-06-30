package com.zybooks.foodamy.presentation.navigation

import com.zybooks.foodamy.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Recipe : BottomNavItem("Recipe", R.drawable.ic_home,"recipe")
    object Liked: BottomNavItem("Liked",R.drawable.ic_outline_navigation_24,"liked")
    object Users: BottomNavItem("Users",R.drawable.ic_baseline_stars_24,"users")
    object Menu: BottomNavItem("Menu",R.drawable.ic_baseline_menu_24,"menu")

}
