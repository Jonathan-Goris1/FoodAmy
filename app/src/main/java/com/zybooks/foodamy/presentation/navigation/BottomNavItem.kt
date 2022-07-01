package com.zybooks.foodamy.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.zybooks.foodamy.R

sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val icon :Int,
    val screen_route : String
    ){

    object Recipe : BottomNavItem(R.string.recipe, R.drawable.ic_home,"recipe")
    object Liked: BottomNavItem(R.string.liked,R.drawable.ic_outline_navigation_24,"liked")
    object Users: BottomNavItem(R.string.users,R.drawable.ic_baseline_stars_24,"users")
    object Menu: BottomNavItem(R.string.menu,R.drawable.ic_baseline_menu_24,"menu")

}
