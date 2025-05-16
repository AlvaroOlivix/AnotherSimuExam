package com.example.anothersimulacro.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.anothersimulacro.feature.task.data.local.room.TaskDao
import com.example.anothersimulacro.feature.task.data.local.room.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TaskDataBase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}