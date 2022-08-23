package com.test.data.db.service

import com.test.data.db.daos.UsersDao
import com.test.data.db.entities.fromEntity
import com.test.data.db.entities.toEntity
import com.test.model.User
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class UsersService(
    private val usersDao: UsersDao
) {

    suspend fun getUser(uuid: String): User {
        return usersDao.getUser(uuid).fromEntity()
    }

    suspend fun getUsers(): List<User> {
        return usersDao.getUsers().map { it.fromEntity() }
    }

    suspend fun insertUser(users: List<User>) {
        users.map { usersDao.insertUser(it.toEntity()) }
    }
}