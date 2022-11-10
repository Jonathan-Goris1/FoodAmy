package com.zybooks.foodamy.presentation.home_screens.users_info

import com.zybooks.foodamy.domain.model.Recipe
import com.zybooks.foodamy.domain.model.User

data class UserScreenState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val user: User = User(),
    val userRecipe: List<Recipe> = emptyList(),
    val userLikes: List<Recipe> = emptyList()

)
