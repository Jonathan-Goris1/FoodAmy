package com.zybooks.foodamy.di

import android.app.Application
import androidx.room.Room
import com.zybooks.foodamy.data.local.dao.RecipeDao
import com.zybooks.foodamy.data.local.dao.RemoteKeysDao
import com.zybooks.foodamy.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRemoteKeysDao(appDatabase: AppDatabase): RemoteKeysDao {
        return appDatabase.remoteKeysDao
    }

    @Provides
    @Singleton
    fun provideRecipeDao(appDatabase: AppDatabase): RecipeDao {
        return appDatabase.recipeDao
    }

    @Provides
    @Singleton
    fun provideRecipeDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "recipeDB.db"
        ).fallbackToDestructiveMigration().build()
    }
}