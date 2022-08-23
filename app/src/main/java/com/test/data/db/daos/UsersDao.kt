package com.test.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.test.data.db.entities.UserEntity

@Dao
interface UsersDao {

    @Query("SELECT * FROM users WHERE login_uuid = :uuid")
    suspend fun getUser(uuid: String): UserEntity

    @Query("SELECT * FROM users ORDER BY name_last")
    suspend fun getUsers(): List<UserEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertUser(user: UserEntity)
}