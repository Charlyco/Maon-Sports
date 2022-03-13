package com.limitless.moansports.services

import com.limitless.moansports.data.Competitions
import com.limitless.moansports.data.CompetitionsItem
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface CompetitionsServices {
    @GET("competitions")
    fun getCompetitionAsync(): Deferred<Response<Competitions>>


    @GET("competitions/{id}/teams")
    fun getTeams(): Call<List<String>>
}