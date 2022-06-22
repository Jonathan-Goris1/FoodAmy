package com.zybooks.foodamy.di

import com.zybooks.foodamy.data.repository.AuthRepositoryImpl
import com.zybooks.foodamy.data.repository.RecipeRepositoryImpl
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository


    @Binds
    @Singleton
    abstract fun bindRecipeRepository(
        recipeRepositoryImpl: RecipeRepositoryImpl
    ): RecipeRepository
}