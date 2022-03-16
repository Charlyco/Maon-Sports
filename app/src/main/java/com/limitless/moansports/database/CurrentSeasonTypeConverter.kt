package com.limitless.moansports.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.limitless.moansports.data.CurrentSeason

class CurrentSeasonTypeConverter {
    @TypeConverter
    fun jsonToSeason(string: String?): CurrentSeason? {
        val gson = Gson()
        val type = object : TypeToken<CurrentSeason>(){}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun seasonToJson(season: CurrentSeason?): String? {
        val gson = Gson()
        val type = object : TypeToken<CurrentSeason>(){}.type
        return gson.toJson(season, type)
    }
}