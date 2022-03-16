package com.limitless.moansports

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.limitless.moansports.data.Competitions
import com.limitless.moansports.data.CompetitionsItem
import com.limitless.moansports.data.TeamsItem
import com.limitless.moansports.database.CompetitionsRepository
import com.limitless.moansports.services.ServicesBuilder
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CompetitionsViewModel(private val application: Application) : ViewModel() {

    private val parentJob = Job()
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val competitionsRepository : CompetitionsRepository =
        CompetitionsRepository(ServicesBuilder.competitionsApi, application)
    val competitionsLiveData = MutableLiveData<MutableList<CompetitionsItem>>()
    var teamsLiveData = MutableLiveData<MutableList<TeamsItem>?>()
    //var teamId = MutableLiveData<Int>()


    fun getCompetitions() {
        scope.launch {
            val competitions = competitionsRepository.getAllCompetitions()
            competitionsLiveData.postValue(competitions)

        }
    }

    fun saveCompetitions() {
        scope.launch {
            val competitions = competitionsRepository.saveCompetitions()
            if (competitions != null) {
                for (i in 0..competitions.lastIndex)
                    competitionsRepository.insert(competitions[i])
            }
        }
    }

//    fun setTeamId(id: Int){
//        teamId.postValue(id)
//    }
    fun getTeams(id: Int) {
        scope.launch {
            val teams = competitionsRepository.getTeams(id)
            if (teams != null) {
                teamsLiveData.postValue(teams)
            }else Log.d("TEAMS MODEL", id.toString())

        }
    }

    fun cancelRequests() = coroutineContext.cancel()
}

class CompetitionsViewModeFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompetitionsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CompetitionsViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}