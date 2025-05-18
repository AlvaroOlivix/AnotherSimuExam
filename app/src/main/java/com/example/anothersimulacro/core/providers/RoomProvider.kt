package com.example.anothersimulacro.core.providers

import android.content.Context
import androidx.room.Room
import com.example.anothersimulacro.core.db.TaskDataBase

object RoomProvider {

    fun providerDb(context: Context): TaskDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            TaskDataBase::class.java,
            "db-tasks"
        ).build()
    }
}