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
    object Liked: BottomNavItem(R.string.likes,R.drawable.ic_baseline_navigation_24,"likes")
    object Users: BottomNavItem(R.string.profile,R.drawable.ic_baseline_stars_24,"profile")
    object Menu: BottomNavItem(R.string.menu,R.drawable.ic_round_menu_24,"menu")

}
