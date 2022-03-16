package com.limitless.moansports.database

import android.app.Application
import com.limitless.moansports.data.CompetitionsItem
import com.limitless.moansports.data.TeamsItem
import com.limitless.moansports.services.CompetitionsServices

class CompetitionsRepository(private val apiService: CompetitionsServices,
                             application: Application): BaseRepository() {
    private var database = CompetitionsDatabase.getDatabase(application)
    var dao: CompetitionsDao = database.competitionsDao()

    suspend fun saveCompetitions(): MutableList<CompetitionsItem>? {
        return safeApiCall(
            call = {apiService.getCompetitionAsync().await()},
            error = "Could not fetch Competitions"
        )?.competitions?.toMutableList()
    }

    suspend fun insert(item: CompetitionsItem) = dao.insertAll(item)

    fun getAllCompetitions(): MutableList<CompetitionsItem> {
        return dao.getAllCompetitions()
    }

    suspend fun getTeams(id: Int): MutableList<TeamsItem>? {
        return safeApiCall(
            call = {apiService.getTeamsAsync(id).await()},
            error = "Could not fetch Competitions"
        )?.teams?.toMutableList()
    }

}