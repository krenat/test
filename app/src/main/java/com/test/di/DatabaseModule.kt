package com.test.di

import android.content.Context
import androidx.room.Room
import com.test.data.db.Database
import com.test.data.db.service.UsersService
import com.test.data.network.UsersApi
import com.test.domain.UsersRepository
import com.test.model.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): Database {
        return Room.databaseBuilder(appContext, Database::class.java, "database").build()
    }

    @Singleton
    @Provides
    fun provideDbService(database: Database): UsersService {
        return UsersService(database.usersDao())
    }
}