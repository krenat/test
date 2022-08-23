package com.test.data.network.model

import com.google.gson.annotations.SerializedName

data class UsersRepsonse(
    @SerializedName("results") val results: List<UserResponse>
)

data class UserResponse (
    @SerializedName("id") val id: UserIdResponse,
    @SerializedName("gender") val gender: String,
    @SerializedName("name") val name: UserNameResponse,
//    @SerializedName("location") val location: LocationResponse,
    @SerializedName("email") val email: String,
    @SerializedName("login") val login: LoginResponse,
    @SerializedName("dob") val dob: AgeResponse,
    @SerializedName("registered") val registered: AgeResponse,
    @SerializedName("phone") val phone: String,
    @SerializedName("cell") val cell: String,
    @SerializedName("nat") val nat: String,
    @SerializedName("picture") val picture: PictureResponse,
)

data class UserNameResponse(
    @SerializedName("title") val title: String,
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
)

data class LoginResponse(
    @SerializedName("uuid") val uuid: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("salt") val salt: String,
    @SerializedName("md5") val md5: String,
    @SerializedName("sha1") val sha1: String,
    @SerializedName("sha256") val sha256: String,
)

data class AgeResponse(
    @SerializedName("date") val date: String,
    @SerializedName("age") val age: Int,
)

data class UserIdResponse(
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: String?,
)

data class PictureResponse(
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("thumbnail") val thumbnail: String,
)