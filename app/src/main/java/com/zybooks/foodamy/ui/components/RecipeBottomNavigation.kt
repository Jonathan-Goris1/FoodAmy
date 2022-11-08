package com.zybooks.foodamy.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zybooks.foodamy.R
import com.zybooks.foodamy.presentation.navigation.BottomNavItem

@Composable
fun RecipeBottomNavigation(
    navController: NavController,
) {
    val items = listOf(
        BottomNavItem.Recipe,
        BottomNavItem.Liked,
        BottomNavItem.Users,
        BottomNavItem.Menu,
        )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomBarDestination = items.any{it.screen_route == currentRoute}


    if(bottomBarDestination) {
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.lightGrey),
            contentColor = Color.White
        ) {


            items.map {
                val selected = currentRoute == it.screen_route
                BottomNavigationItem(
                    icon = {
                        if(selected){
                            Icon(
                                painterResource(id = it.icon),
                                contentDescription = "",
                                tint = Color.Red
                            )
                        }
                        else{
                            Icon(
                                painterResource(id = it.icon),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }

                     },
                    label = {
                        if(selected){
                            Text(
                                text = stringResource(id = it.title),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Red
                            )
                        }else{
                            Text(
                            text = stringResource(id = it.title),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )}

                    },
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = selected,
                    onClick = {
                        navController.navigate(it.screen_route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                    inclusive = true
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
}
