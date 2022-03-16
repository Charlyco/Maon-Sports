package com.limitless.moansports.services

import com.limitless.moansports.data.Competitions
import com.limitless.moansports.data.Teams
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CompetitionsServices {
    @GET("competitions")
    fun getCompetitionAsync(): Deferred<Response<Competitions>>

    @GET("competitions/{id}/teams")
    fun getTeamsAsync(@Path("id") id: Int): Deferred<Response<Teams>>
}