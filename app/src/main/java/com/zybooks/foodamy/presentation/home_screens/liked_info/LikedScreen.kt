package com.zybooks.foodamy.presentation.home_screens.liked_info

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun LikedScreen(
    navController: NavController,
    viewModel: LikeScreenViewModel = hiltViewModel()
) {

        Column {
//            LikedScreenCard(Recipe =, likesData =) {

            }


}

@Preview
@Composable
fun LikedScreenPreview() {

}


