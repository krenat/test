package com.test.domain

import com.test.data.db.service.UsersService
import com.test.data.network.RequestWrapper
import com.test.data.network.UsersApi
import com.test.data.network.model.ResultResponse
import com.test.model.*
import javax.inject.Inject


class UsersRepository @Inject constructor(
    private val usersService: UsersService,
    private val usersApi: UsersApi
) {

    suspend fun getUser(uuid: String): User {
        return usersService.getUser(uuid)
    }

    suspend fun getStoredUsers(): List<User> {
        return  usersService.getUsers()
    }

    suspend fun storeUsers(users: List<User>) {
        usersService.insertUser(users)
    }

    suspend fun getUsers(countUsers: Int): ResultResponse<List<User>> {
        return RequestWrapper().makeRequest {
            usersApi.getUsers(countUsers).results.map { it.toUser() }
        }
    }
}