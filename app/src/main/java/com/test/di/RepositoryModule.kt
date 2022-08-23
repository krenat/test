package com.test.di

import com.test.data.db.service.UsersService
import com.test.data.network.UsersApi
import com.test.domain.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesUserRepository(usersService: UsersService, usersApi: UsersApi): UsersRepository {
        return UsersRepository(usersService, usersApi)
    }
}