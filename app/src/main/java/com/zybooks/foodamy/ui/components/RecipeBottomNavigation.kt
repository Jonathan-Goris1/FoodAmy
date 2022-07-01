package com.zybooks.foodamy.ui.components

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zybooks.foodamy.R
import com.zybooks.foodamy.presentation.navigation.BottomNavItem
import com.zybooks.foodamy.ui.theme.DarkRed

@Composable
fun RecipeBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Recipe,
        BottomNavItem.Liked,
        BottomNavItem.Users,
        BottomNavItem.Menu,

        )
    androidx.compose.material.BottomNavigation(
        backgroundColor = colorResource(id = R.color.lightGrey),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = "") },
                label = {
                    Text(
                        text = stringResource(id = item.title),
                        fontSize = 9.sp,
                        color = Color.DarkGray
                    )
                },
                selectedContentColor = DarkRed,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
