package com.test.model


data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
//    val postcode: String,
    val coordinates: Coordinates,
    val timezone: Timezone,
)

data class Street(
    val number: Int,
    val name: String,
)

data class Coordinates(
    val latitude: String,
    val longitude: String,
)

data class Timezone(
    val offset: String,
    val description: String,
)