package com.limitless.moansports.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class CurrentSeason(@SerializedName("currentMatchday")
                         val currentMatchday: Int? = 0,
                         @SerializedName("endDate")
                         val endDate: String? = "",
                         @SerializedName("id")
                         @PrimaryKey
                         val id: Int = 0,
                         @SerializedName("startDate")
                         val startDate: String? = "")