package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName

data class TeamsItem(@SerializedName("area")
                     val area: Area,
                     @SerializedName("venue")
                     val venue: String = "",
                     @SerializedName("website")
                     val website: String = "",
                     @SerializedName("address")
                     val address: String = "",
                     @SerializedName("crestUrl")
                     val crestUrl: String = "",
                     @SerializedName("tla")
                     val tla: String = "",
                     @SerializedName("founded")
                     val founded: Int = 0,
                     @SerializedName("lastUpdated")
                     val lastUpdated: String = "",
                     @SerializedName("clubColors")
                     val clubColors: String = "",
                     @SerializedName("phone")
                     val phone: String = "",
                     @SerializedName("name")
                     val name: String = "",
                     @SerializedName("id")
                     val id: Int = 0,
                     @SerializedName("shortName")
                     val shortName: String = "",
                     @SerializedName("email")
                     val email: String = "")