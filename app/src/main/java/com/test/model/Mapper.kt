package com.test.model

import com.test.data.network.model.*

fun UserResponse.toUser() = User(
    id = id.toUserId(),
    gender = gender,
    name = name.toUserName(),
    email = email,
    login = login.toLogin(),
    dob = dob.toAge(),
    registered = registered.toAge(),
    phone = phone,
    cell = cell,
    nat = nat,
    picture = picture.toPicture()
)

fun UserNameResponse.toUserName() = UserName(
    title = title,
    first = first,
    last = last
)

fun LoginResponse.toLogin() = Login(
    uuid = uuid,
    username = username,
    password = password,
    salt = salt,
    md5 = md5,
    sha1 = sha1,
    sha256 = sha256,
)

fun AgeResponse.toAge() = Age(
    date = date,
    age = age,
)

fun UserIdResponse.toUserId() = UserId(
    name = name,
    value = value
)

fun PictureResponse.toPicture() = Picture(
    large = large,
    medium = medium,
    thumbnail = thumbnail,
)

fun LocationResponse.toLocation() = Location(
    street = street.toStreet(),
    city = city,
    state = state,
    country = country,
//    postcode = postcode,
    coordinates = coordinates.toCoordinates(),
    timezone = timezone.toTimezone(),
)

fun StreetResponse.toStreet() = Street(
    number = number,
    name = name,
)

fun CoordinatesResponse.toCoordinates() = Coordinates(
    latitude = latitude,
    longitude = longitude,
)

fun TimezoneResponse.toTimezone() = Timezone(
    offset = offset,
    description = description,
)