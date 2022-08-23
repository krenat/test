package com.test.data.network.model

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("street") val street: StreetResponse,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
//    @SerializedName("postcode") val postcode: String,
    @SerializedName("coordinates") val coordinates: CoordinatesResponse,
    @SerializedName("timezone") val timezone: TimezoneResponse,
)

data class StreetResponse(
    @SerializedName("number") val number: Int,
    @SerializedName("name") val name: String,
)

data class CoordinatesResponse(
    @SerializedName("latitude") val latitude: String,
    @SerializedName("longitude") val longitude: String,
)

data class TimezoneResponse(
    @SerializedName("offset") val offset: String,
    @SerializedName("description") val description: String,
)