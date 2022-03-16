package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName

data class Season(@SerializedName("currentMatchday")
                  val currentMatchday: String? = null,
                  @SerializedName("endDate")
                  val endDate: String = "",
                  @SerializedName("availableStages")
                  val availableStages: List<String>?,
                  @SerializedName("id")
                  val id: Int = 0,
                  @SerializedName("startDate")
                  val startDate: String = "")