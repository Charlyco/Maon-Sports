package com.limitless.moansports.services

sealed class ApiResult<out T : Any>{
    data class Success<out T : Any>(val output : T) : ApiResult<T>()
    data class Error(val exception: Exception)  : ApiResult<Nothing>()
}
