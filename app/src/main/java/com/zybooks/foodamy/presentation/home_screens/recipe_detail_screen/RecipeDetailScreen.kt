package com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.zybooks.foodamy.R
import com.zybooks.foodamy.presentation.home_screens.recipe_detail_screen.components.RecipeDetailCard
import com.zybooks.foodamy.ui.theme.DarkRed

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeDetailScreen(
    onNavigateBackToEditorChoice: () -> Boolean?,
    recipeID: Int?,
    viewModel: RecipeDetailViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()
    val recipe = viewModel.state.recipe
    val comment = viewModel.state.comment
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Recipe Name",  color = Color.White)

                    }

                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateBackToEditorChoice() }) {
                        androidx.compose.material.Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go Back"
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
                            modifier = Modifier.size(20.dp, 20.dp),
                            painter = painterResource(id = R.drawable.ic_baseline_share_24),
                            tint = DarkRed,
                            contentDescription = "Share Recipe"
                        )
                    }


                }
            )
        },

        ) {

        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())) {
            RecipeDetailCard(recipe = recipe, comment =  comment)
        }

    }

}