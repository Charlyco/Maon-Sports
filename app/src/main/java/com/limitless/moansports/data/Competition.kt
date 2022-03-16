package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName

data class Competition(@SerializedName("area")
                       val area: Area,
                       @SerializedName("lastUpdated")
                       val lastUpdated: String = "",
                       @SerializedName("code")
                       val code: String = "",
                       @SerializedName("name")
                       val name: String = "",
                       @SerializedName("id")
                       val id: Int = 0,
                       @SerializedName("plan")
                       val plan: String = "")