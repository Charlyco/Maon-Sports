package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName

data class Area(@SerializedName("countryCode")
                val countryCode: String = "",
                @SerializedName("name")
                val name: String = "",
                @SerializedName("id")
                val id: Int = 0)