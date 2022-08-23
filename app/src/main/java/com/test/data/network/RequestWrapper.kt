package com.test.data.network

import com.test.data.network.model.ResultResponse
import retrofit2.HttpException
import java.io.IOException

class RequestWrapper {
    suspend fun <T> makeRequest(doRequest: suspend () -> T): ResultResponse<T> {
        return try {
            val response = doRequest()
            ResultResponse.Success(response)
        } catch (throwable: Throwable) {
             when (throwable) {
                is IOException -> ResultResponse.Error("network error")
                is HttpException -> ResultResponse.Error(throwable.message())
                else -> ResultResponse.Error("some error")
            }
        }
    }
}