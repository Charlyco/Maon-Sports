package com.limitless.moansports.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.limitless.moansports.data.CompetitionsItem


@Dao
interface CompetitionsDao {
    @Query("SELECT * from competitions")
    fun getAllCompetitions(): MutableList<CompetitionsItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll (vararg competitions: CompetitionsItem)
}