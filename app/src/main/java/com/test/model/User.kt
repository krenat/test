package com.test.model


data class User (
    val id: UserId,
    val gender: String,
    val name: UserName,
//    val location: Location,
    val email: String,
    val login: Login,
    val dob: Age,
    val registered: Age,
    val phone: String,
    val cell: String,
    val nat: String,
    val picture: Picture
) {
    fun getName(): String {
        val userName: StringBuilder = StringBuilder("")
        if(name.title.isNotEmpty()) {
            userName.append(name.title).append(" ")
        }
        userName.append(name.first).append(" ")
        userName.append(name.last)
        return userName.toString()
    }
}

data class UserName(
    val title: String,
    val first: String,
    val last: String
)

data class Login(
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String,
)

data class Age(
    val date: String,
    val age: Int,
)

data class UserId(
    val name: String,
    val value: String?,
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String,
)