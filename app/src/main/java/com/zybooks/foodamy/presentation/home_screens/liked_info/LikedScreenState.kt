package com.zybooks.foodamy.presentation.home_screens.liked_info

import androidx.paging.PagingData
import com.zybooks.foodamy.domain.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class LikedScreenState (
    val isLoading: Boolean = false,
    val error: String? = null,
    val recipes: Flow<PagingData<Category>> = emptyFlow()
)