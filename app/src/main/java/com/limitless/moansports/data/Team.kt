package com.limitless.moansports.data

import com.google.gson.annotations.SerializedName
import com.limitless.moansports.data.Area
import com.limitless.moansports.data.Squad


data class ExampleJson2KtKotlin (

  @SerializedName("id"          ) var id          : Int?             = null,
  @SerializedName("area"        ) var area        : Area?            = Area(),
  @SerializedName("name"        ) var name        : String?          = null,
  @SerializedName("shortName"   ) var shortName   : String?          = null,
  @SerializedName("tla"         ) var tla         : String?          = null,
  @SerializedName("address"     ) var address     : String?          = null,
  @SerializedName("phone"       ) var phone       : String?          = null,
  @SerializedName("website"     ) var website     : String?          = null,
  @SerializedName("email"       ) var email       : String?          = null,
  @SerializedName("founded"     ) var founded     : Int?             = null,
  @SerializedName("clubColors"  ) var clubColors  : String?          = null,
  @SerializedName("venue"       ) var venue       : String?          = null,
  @SerializedName("squad"       ) var squad       : ArrayList<Squad> = arrayListOf(),
  @SerializedName("lastUpdated" ) var lastUpdated : String?          = null

)