package com.test.data.network.model


sealed class ResultResponse<T> {
    class Success<T>(val data: T): ResultResponse<T>()
    class Error<T>(val message: String): ResultResponse<T>()
}