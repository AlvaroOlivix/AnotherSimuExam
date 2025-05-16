package com.example.anothersimulacro.feature.task.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTask(task: TaskEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllTasks(vararg tasks: TaskEntity)

    @Query("SELECT * FROM taskTable WHERE id = :taskId")
    fun getTaskById(taskId: String): TaskEntity?

    @Query("SELECT * FROM taskTable")
    fun getAll(): List<TaskEntity>

    @Delete
    fun delete(task: TaskEntity)

}