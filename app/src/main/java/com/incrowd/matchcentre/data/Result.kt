package com.incrowd.matchcentre.data

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

val Result<*>.successful
    get() = this is Result.Success && data != null