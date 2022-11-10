package com.zybooks.foodamy.data.repository

import com.zybooks.foodamy.data.mapper.toDomainModel
import com.zybooks.foodamy.data.remote.network_api.UserApi
import com.zybooks.foodamy.data.repository.base.BaseRepository
import com.zybooks.foodamy.domain.model.Recipe
import com.zybooks.foodamy.domain.model.User
import com.zybooks.foodamy.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
) : UserRepository, BaseRepository() {

    override suspend fun getUserDetails(userId: Int): User =
        execute {
            userApi.getUserDetails(userId).toDomainModel()
        }

    override suspend fun getUSerRecipe(userID: Int): List<Recipe> =
        execute {
            val remote = userApi.getUserRecipes(userID).data
            remote.map { it.toDomainModel() }
        }

    override suspend fun getUSerLikes(): List<Recipe> =
        execute {
            val remote = userApi.getUserLikes().data
            remote.map { it.toDomainModel() }
        }




}