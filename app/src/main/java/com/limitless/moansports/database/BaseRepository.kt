package com.limitless.moansports.database

import android.util.Log
import com.limitless.moansports.services.ApiResult
import retrofit2.Response
import java.io.IOException

open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call : suspend()-> Response<T>, error : String) : T?{
        val result = competitionsOutput(call, error)
        var output : T? = null
        when(result){
            is ApiResult.Success ->
                output = result.output
            is ApiResult.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output

    }
    private suspend fun<T : Any> competitionsOutput(call: suspend()-> Response<T>, error: String) : ApiResult<T>{
        val response = call.invoke()
        return if (response.isSuccessful)
            ApiResult.Success(response.body()!!)
        else
            ApiResult.Error(IOException("OOps .. Something went wrong due to  $error"))
    }
}