package com.pce.android.track20.internal.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringArrayTypeConverter {
    @TypeConverter
    fun fromString(string: String): List<String> =
        Gson().fromJson(string, object : TypeToken<List<String>>() {}.type)

    @TypeConverter
    fun fromList(list: List<String>): String = Gson().toJson(list)
}