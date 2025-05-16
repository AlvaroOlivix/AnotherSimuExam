package com.example.anothersimulacro.core.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.anothersimulacro.feature.task.domain.State
import com.google.gson.Gson

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromStateToData(state: State): String {
        return gson.toJson(state)
    }

    @TypeConverter
    fun fromDataToStateModel(data: String): State {
        return gson.fromJson(data, State::class.java)
    }
}