package com.limitless.moansports.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "competitions")
data class CompetitionsItem(@SerializedName("area")
                            @Embedded(prefix = "ar_")
                            val area: Area?,
                            @SerializedName("code")
                            val code: String? = "",
                            @SerializedName("currentSeason")
                            @Embedded(prefix = "sea_")
                            val currentSeason: CurrentSeason?,
                            @SerializedName("name")
                            val name: String? = "",
                            @SerializedName("id")
                            @PrimaryKey
                            val id: Int = 0,
                            @SerializedName("numberOfAvailableSeasons")
                            val numberOfAvailableSeasons: Int = 0)