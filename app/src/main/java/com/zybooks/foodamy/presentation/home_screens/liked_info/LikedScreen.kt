package com.zybooks.foodamy.presentation.home_screens.liked_info

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.zybooks.foodamy.ui.components.LikedScreenCard


@Composable
fun LikedScreen(
    navController: NavController,
    viewModel: LikeScreenViewModel = hiltViewModel()
) {
    val categoryItems = viewModel.state.recipes.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier.padding(0.dp,0.dp, 0.dp,48.dp)
    ) {
        items(categoryItems.itemCount) { index ->
            categoryItems[index]?.recipes?.let {
                LikedScreenCard(category = categoryItems[index], likesData = it)

            }
        }
    }


}

@Preview
@Composable
fun LikedScreenPreview() {

}


