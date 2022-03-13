package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName

data class CurrentSeason(@SerializedName("currentMatchday")
                         val currentMatchday: Int = 0,
                         @SerializedName("endDate")
                         val endDate: String = "",
                         @SerializedName("id")
                         val id: Int = 0,
                         @SerializedName("startDate")
                         val startDate: String = "")