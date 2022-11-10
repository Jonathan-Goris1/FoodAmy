package com.zybooks.foodamy.domain.repository

import com.zybooks.foodamy.domain.model.Recipe
import com.zybooks.foodamy.domain.model.User

interface UserRepository {

    suspend fun getUserDetails(userId: Int): User

    suspend fun getUSerRecipe(userID: Int): List<Recipe>

    suspend fun getUSerLikes(): List<Recipe>
}
