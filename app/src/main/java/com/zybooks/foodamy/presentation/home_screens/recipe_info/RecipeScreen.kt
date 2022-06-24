package com.zybooks.foodamy.presentation.home_screens.recipe_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.R
import com.zybooks.foodamy.ui.components.RecipeCard
import com.zybooks.foodamy.ui.theme.DarkRed
import java.util.*


@Composable
fun RecipeHomeScreen(viewModel: RecipeScreenViewModel = hiltViewModel()){
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_foodamy___flat),
                        contentDescription = null
                    )

                }

                },
                backgroundColor = DarkRed,
                actions = {
                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .size(30.dp, 30.dp),
                        onClick = { /* doSomething() */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_search_24),
                            tint = DarkRed,
                            contentDescription = "Search Recipe")
                    }


                }
            )
        },
        bottomBar = { BottomNavigation(navController = navController)}
    ) {


        Column {
            //NavigationGraph(navController = navController)
            DoubleButtonScreen()
            LazyColumn{
                viewModel.state.recipes?.let { it1 ->
                    items(it1.size){
                        it1.forEach { data -> RecipeCard(Recipe = data) {
                            
                        } }
                    }
                }

            }

        }


    }
}

@Composable
fun DoubleButtonScreen(){
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier.weight(1.0f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            onClick = { /*TODO*/ }) {
            Text(text = "Editors Choice", color = Color.DarkGray)
            
        }
        Column {
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
                color = Color.DarkGray,
                thickness = 1.dp
            )

        }


        Button(
            modifier = Modifier.weight(1.0f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            onClick = { /*TODO*/ }) {
            Text(text = "Recently Added", color = Color.DarkGray)

        }


    }
}




@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Recipe,
        BottomNavItem.Liked,
        BottomNavItem.Users,
        BottomNavItem.Menu,

    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.lightGrey),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title.uppercase(Locale.getDefault()),
                    fontSize = 9.sp,
                color = Color.DarkGray) },
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

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Recipe.screen_route) {
        composable(BottomNavItem.Recipe.screen_route) {
            RecipeHomeScreen()
        }
        composable(BottomNavItem.Liked.screen_route) {

        }
        composable(BottomNavItem.Users.screen_route) {

        }
        composable(BottomNavItem.Menu.screen_route) {

        }

    }
}

@Preview
@Composable
fun RecipeHomeScreenPreview(){
    RecipeHomeScreen()
}

