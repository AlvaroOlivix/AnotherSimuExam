package com.example.anothersimulacro.core.db

import android.content.Context
import androidx.room.Room

object RoomProvider {

    fun providerDb(context: Context): TaskDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            TaskDataBase::class.java,
            "db-tasks"
        ).build()
    }
}