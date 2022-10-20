package com.zybooks.foodamy.di

import com.zybooks.foodamy.data.local.dao.RemoteKeysDao
import com.zybooks.foodamy.data.local.database.AppDatabase
import com.zybooks.foodamy.data.remote.network_api.AuthApi
import com.zybooks.foodamy.data.remote.network_api.RecipeApi
import com.zybooks.foodamy.data.repository.AuthRepositoryImpl
import com.zybooks.foodamy.data.repository.RecipeRepositoryImpl
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
     fun bindAuthRepository(
       api: AuthApi
    ): AuthRepository{
         return AuthRepositoryImpl(api)
     }


    @Provides
    @Singleton
    fun bindRecipeRepository(
        api: RecipeApi,
        database: AppDatabase,
        remoteKeysDao: RemoteKeysDao
    ): RecipeRepository{
        return RecipeRepositoryImpl(api, database.recipeDao, remoteKeysDao)
    }
}