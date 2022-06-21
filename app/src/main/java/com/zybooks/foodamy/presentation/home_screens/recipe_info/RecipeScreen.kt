package com.zybooks.foodamy.presentation.home_screens.recipe_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.R
import com.zybooks.foodamy.ui.theme.DarkRed


@Composable
fun RecipeHomeScreen(){
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
        bottomBar = {BottomNavigation(navController = navController)}
    ) {


        Column {
            //NavigationGraph(navController = navController)
            DoubleButtonScreen()
            RecipeInfo()
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
        Column() {
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
fun RecipeInfo(){
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            modifier = Modifier
                .padding(8.dp),
            painter = painterResource(id = R.drawable.ic_baseline_face_24),
            contentDescription = null)

        Column() {
            Text(text = "Username")
            Row() {
                Text(text = "Specification")
                Text(text = "Followers")
            }


        }
    }

    Column{
        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.LightGray,
            thickness = 1.dp
        )
        
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Recipe name",
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp ),
            text = "Category name",
            fontSize = 12.sp
        )

        Image(
            modifier = Modifier
                .width(400.dp)
                .height(400.dp)
                .padding(8.dp),
            painter = painterResource(id = R.drawable.ic_baseline_face_24),
            contentDescription = null)
        
        Row() {
            Text(
                modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp ),
                text = "Comments and Taste")
            
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
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
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

