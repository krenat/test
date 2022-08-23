package com.test.data.db.entities

import com.test.model.*

fun User.toEntity() = UserEntity(
    uuid = login.uuid,
    username = login.username,
    password = login.password,
    salt = login.salt,
    md5 = login.md5,
    sha1 = login.sha1,
    sha256 = login.sha256,

    idName = id.name,
    idValue = id.value,

    gender = gender,
    nameTitle = name.title,
    nameFirst = name.first,
    nameLast = name.last,
    email = email,

    dobDate = dob.date,
    dobAge = dob.age,
    registeredDate = registered.date,
    registeredAge = registered.age,

    phone = phone,
    cell = cell,
    nat = nat,
    large = picture.large,
    medium = picture.medium,
    thumbnail = picture.thumbnail,
)

fun UserEntity.fromEntity() = User(
    login = Login(
        uuid = uuid,
        username = username,
        password = password,
        salt = salt,
        md5 = md5,
        sha1 = sha1,
        sha256 = sha256,
    ),

    id = UserId(
        name = idName,
        value = idValue,
    ),

    name = UserName(
        title = nameTitle,
        first = nameFirst,
        last = nameLast,
    ),

    gender = gender,
    email = email,
    phone = phone,
    cell = cell,
    nat = nat,

    dob = Age(
        date = dobDate,
        age = dobAge,
    ),
    registered = Age(
        date = registeredDate,
        age = registeredAge,
    ),

    picture = Picture(
        large = large,
        medium = medium,
        thumbnail = thumbnail,
    )
)