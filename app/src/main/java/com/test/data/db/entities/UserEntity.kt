package com.test.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.test.data.network.model.LocationResponse

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey @ColumnInfo(name = "login_uuid") val uuid: String,
    @ColumnInfo(name = "login_username") val username: String,
    @ColumnInfo(name = "login_password") val password: String,
    @ColumnInfo(name = "login_salt") val salt: String,
    @ColumnInfo(name = "login_md5") val md5: String,
    @ColumnInfo(name = "login_sha1") val sha1: String,
    @ColumnInfo(name = "login_sha256") val sha256: String,

    @ColumnInfo(name = "id_name") val idName: String,
    @ColumnInfo(name = "id_value") val idValue: String?,

    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "name_title") val nameTitle: String,
    @ColumnInfo(name = "name_first") val nameFirst: String,
    @ColumnInfo(name = "name_last") val nameLast: String,
    @ColumnInfo(name = "email") val email: String,

    @ColumnInfo(name = "dob_date") val dobDate: String,
    @ColumnInfo(name = "dob_age") val dobAge: Int,
    @ColumnInfo(name = "registered_date") val registeredDate: String,
    @ColumnInfo(name = "registered_age") val registeredAge: Int,

    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "cell") val cell: String,
    @ColumnInfo(name = "nat") val nat: String,
    @ColumnInfo(name = "pict_large") val large: String,
    @ColumnInfo(name = "pict_medium") val medium: String,
    @ColumnInfo(name = "pict_thumbnail") val thumbnail: String,
)

