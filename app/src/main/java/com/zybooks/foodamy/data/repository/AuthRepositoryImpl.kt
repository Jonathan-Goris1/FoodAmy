package com.zybooks.foodamy.data.repository

import com.zybooks.foodamy.data.mapper.toDomainModel
import com.zybooks.foodamy.data.remote.network_api.AuthApi
import com.zybooks.foodamy.data.repository.base.BaseRepository
import com.zybooks.foodamy.domain.model.Auth
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.domain.utils.DataStoreManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val dataStoreManager: DataStoreManager
): AuthRepository, BaseRepository() {


    override suspend fun register(email: String, password: String, username: String): Auth =
        execute {
            api.register(email, password, username).toDomainModel()
        }

    override suspend fun forgot(email: String): Auth =
        execute {
            api.forgot(email).toDomainModel()
        }

//    override suspend fun logout(): Common =
//        execute {
//            val response = api.logout().toDomainModel()
//            dataStoreManager.removeUserId()
//            dataStoreManager.removeToken()
//            response
//        }

    override suspend fun login(email: String, password: String): Unit =
        execute {
            val response = api.login(email, password).toDomainModel()
            dataStoreManager.saveToken(response.token)
            dataStoreManager.saveUserId(response.user.id)
        }

}