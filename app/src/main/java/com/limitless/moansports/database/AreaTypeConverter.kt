package com.limitless.moansports.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.limitless.moansports.data.Area

class AreaTypeConverter {
    @TypeConverter
    fun jsonToArea(string: String?): Area? {
        val gson = Gson()
        val type = object : TypeToken<Area>(){}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun areaToJson(area: Area?): String? {
        val gson = Gson()
        val type = object : TypeToken<Area>(){}.type
        return gson.toJson(area, type)
    }
}