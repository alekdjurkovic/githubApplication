package com.example.github.data.result

import com.example.github.domain.model.DataResult

sealed interface NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>
    data class HttpError(val code: Int, val message: String) : NetworkResult<Nothing>
    data class NetworkError(val cause: Throwable) : NetworkResult<Nothing>
    data class UnknownError(val cause: Throwable) : NetworkResult<Nothing>
}

// Executes a suspend API call and wraps the outcome into a NetworkResult.
suspend fun <T> safeApiCall(call: suspend () -> T): NetworkResult<T> = try {
    NetworkResult.Success(call())
} catch (e: retrofit2.HttpException) {
    NetworkResult.HttpError(
        code = e.code(),
        message = e.message() ?: "HTTP ${e.code()}",
    )
} catch (e: java.io.IOException) {
    NetworkResult.NetworkError(cause = e)
} catch (e: Exception) {
    NetworkResult.UnknownError(cause = e)
}

// Maps a NetworkResult to a DataResult — this is the only place the boundary is crossed.
fun <T> NetworkResult<T>.toDataResult(): DataResult<T> = when (this) {
    is NetworkResult.Success -> DataResult.Success(data)
    is NetworkResult.HttpError -> DataResult.Error("HTTP $code: $message")
    is NetworkResult.NetworkError -> DataResult.Error("Network error. Check your connection.", cause)
    is NetworkResult.UnknownError -> DataResult.Error("Unexpected error.", cause)
}
