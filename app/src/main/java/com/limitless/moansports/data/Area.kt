package com.limitless.moansports.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Area(@SerializedName("countryCode")
                val countryCode: String? = "",
                @SerializedName("name")
                val name: String? = "",
                @SerializedName("id")
                @PrimaryKey
                val id: Int = 0)