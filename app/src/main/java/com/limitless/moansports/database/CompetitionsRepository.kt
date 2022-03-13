package com.limitless.moansports.database

import com.limitless.moansports.data.CompetitionsItem
import com.limitless.moansports.services.CompetitionsServices

class CompetitionsRepository(private val apiService: CompetitionsServices): BaseRepository() {
    suspend fun getCompetitions(): MutableList<CompetitionsItem>? {
        return safeApiCall(
            call = {apiService.getCompetitionAsync().await()},
            error = "Could not fetch Competitions"
        )?.competitions?.toMutableList()
    }


}