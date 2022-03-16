package com.limitless.moansports.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
data class Competitions(
                        @SerializedName("count")
                        val count: Int = 0,
                        @SerializedName("competitions")
                        val competitions: List<CompetitionsItem>?,
                        @SerializedName("filters")
                        val filters: Filters
)