package com.framgia.data.source.local

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by VanNhat on 14/11/2018.
 */
class Converter {
    @TypeConverter
    fun fromString(value: String): ArrayList<String> {
        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}