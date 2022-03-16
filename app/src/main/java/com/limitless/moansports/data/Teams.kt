package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName

data class Teams(@SerializedName("teams")
                 val teams: List<TeamsItem>?,
                 @SerializedName("count")
                 val count: Int = 0,
                 @SerializedName("season")
                 val season: Season,
                 @SerializedName("competition")
                 val competition: Competition,
                 @SerializedName("filters")
                 val filters: Filters)