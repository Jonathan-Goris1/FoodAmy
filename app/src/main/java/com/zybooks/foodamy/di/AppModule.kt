package com.zybooks.foodamy.di

import com.zybooks.foodamy.data.remote.AuthApi
import com.zybooks.foodamy.data.remote.RecipeApi
import com.zybooks.foodamy.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthApi(
        retrofit: Retrofit
    ): AuthApi
    {
     return retrofit.create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeApi(
        retrofit: Retrofit
    ): RecipeApi
    {
        return retrofit.create(RecipeApi::class.java)
    }



}