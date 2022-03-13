package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName

data class CompetitionsItem(@SerializedName("area")
                            val area: Area,
                            @SerializedName("code")
                            val code: String = "",
                            @SerializedName("currentSeason")
                            val currentSeason: CurrentSeason,
                            @SerializedName("name")
                            val name: String = "",
                            @SerializedName("id")
                            val id: Int = 0,
                            @SerializedName("numberOfAvailableSeasons")
                            val numberOfAvailableSeasons: Int = 0)