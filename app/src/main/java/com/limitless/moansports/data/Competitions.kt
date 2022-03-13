package com.limitless.moansports.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "competitions")
data class Competitions(
                        @SerializedName("count")
                        @PrimaryKey
                        val count: Int = 0,
                        @SerializedName("competitions")
                        val competitions: List<CompetitionsItem>?,
                        @SerializedName("filters")
                        val filters: Filters
)