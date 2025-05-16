package com.example.anothersimulacro.feature.task.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.anothersimulacro.feature.task.domain.State

private const val TASKTABLE = "taskTable"

@Entity(tableName = TASKTABLE)
class TaskEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "state") val state: State
    //State necesita un converter
)