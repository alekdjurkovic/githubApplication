package com.example.github.data.api

import com.example.github.domain.model.DataResult

suspend fun <T> safeApiCall(call: suspend () -> T): DataResult<T> = try {
    DataResult.Success(call())
} catch (e: retrofit2.HttpException) {
    DataResult.Error("HTTP ${e.code()}: ${e.message() ?: "HTTP ${e.code()}"}", e)
} catch (e: java.io.IOException) {
    DataResult.Error("Network error. Check your connection.", e)
} catch (e: Exception) {
    DataResult.Error("Unexpected error.", e)
}
