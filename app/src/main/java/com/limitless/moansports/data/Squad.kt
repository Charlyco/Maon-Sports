package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName


data class Squad (

  @SerializedName("id"             ) var id             : Int?    = null,
  @SerializedName("name"           ) var name           : String? = null,
  @SerializedName("position"       ) var position       : String? = null,
  @SerializedName("dateOfBirth"    ) var dateOfBirth    : String? = null,
  @SerializedName("countryOfBirth" ) var countryOfBirth : String? = null,
  @SerializedName("nationality"    ) var nationality    : String? = null,
  @SerializedName("role"           ) var role           : String? = null

)