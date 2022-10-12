package com.zybooks.foodamy.di

import android.app.Application
import androidx.room.Room
import com.zybooks.foodamy.data.local.SocialDatabase
import com.zybooks.foodamy.data.remote.network_api.AuthApi
import com.zybooks.foodamy.data.remote.network_api.RecipeApi
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

    @Provides
    @Singleton
    fun provideSocialDatabase(app: Application): SocialDatabase{
        return Room.databaseBuilder(
            app,
            SocialDatabase::class.java,
            "socialDB.db"
        ).build()
    }



}