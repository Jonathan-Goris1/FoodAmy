package com.zybooks.foodamy

import com.zybooks.foodamy.data.remote.network_api.AuthApi
import com.zybooks.foodamy.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TestAppModule {

    @Provides
    @Singleton
    fun provideRetrofit(
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
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
}