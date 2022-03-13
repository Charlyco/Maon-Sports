package com.limitless.moansports

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.limitless.moansports.data.CompetitionsItem
import com.limitless.moansports.database.CompetitionsRepository
import com.limitless.moansports.services.CompetitionsServices
import com.limitless.moansports.services.ServicesBuilder
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CompetitionsViewModel : ViewModel() {

    private val parentJob = Job()
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val competitionsRepository : CompetitionsRepository = CompetitionsRepository(ServicesBuilder.competitionsApi)
    val competitionsLiveData = MutableLiveData<MutableList<CompetitionsItem>>()

    fun getLatestNews() {
        scope.launch {
            val competitions = competitionsRepository.getCompetitions()
            competitionsLiveData.postValue(competitions!!)


        }
    }
    fun cancelRequests() = coroutineContext.cancel()
}