package com.test.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.data.db.daos.UsersDao
import com.test.data.db.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class Database: RoomDatabase() {

    abstract fun usersDao(): UsersDao
}