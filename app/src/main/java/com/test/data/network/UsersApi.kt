package com.test.data.network

import com.test.data.network.model.UsersRepsonse
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {

    @GET("api/")
    suspend fun getUsers(
        @Query("results") id: Int,
    ): UsersRepsonse
}