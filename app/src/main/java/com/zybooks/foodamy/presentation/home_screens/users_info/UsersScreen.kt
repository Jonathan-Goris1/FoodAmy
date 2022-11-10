package com.zybooks.foodamy.presentation.home_screens.users_info

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zybooks.foodamy.presentation.home_screens.users_info.components.UserScreenLikesSection
import com.zybooks.foodamy.presentation.home_screens.users_info.components.UserScreenProfileSection
import com.zybooks.foodamy.presentation.home_screens.users_info.components.UserScreenRecipesSection
import com.zybooks.foodamy.ui.theme.DarkRed

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UsersScreen(
    viewModel: UserScreenViewModel = hiltViewModel()
) {
    val user = viewModel.state.user
    val userRecipes = viewModel.state.userRecipe
    val userLikes = viewModel.state.userLikes
    
        Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("User", textAlign = TextAlign.Center, color = Color.White)
                    }
                },
                backgroundColor = DarkRed,
            )
        },

    ) {
            Column(
                modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(0.dp,0.dp, 0.dp,48.dp)) {

                UserScreenProfileSection(user = user )
                UserScreenRecipesSection(recipes = userRecipes)
                UserScreenLikesSection(Likes = userLikes)
            }

            


    }

}


@Preview
@Composable
fun UsersScreenPreview() {

}