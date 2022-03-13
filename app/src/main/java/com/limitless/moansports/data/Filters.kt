package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("area") var area: Area?= Area(),
)