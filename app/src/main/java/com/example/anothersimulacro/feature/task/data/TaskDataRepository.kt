package com.example.anothersimulacro.feature.task.data

import com.example.anothersimulacro.feature.task.data.local.room.LocalRoomTaskDataSource
import com.example.anothersimulacro.feature.task.domain.Task
import com.example.anothersimulacro.feature.task.domain.TaskRepository

class TaskDataRepository(private val locaRoomData: LocalRoomTaskDataSource) : TaskRepository {
    override suspend fun getAllTasks(): List<Task> {
        return locaRoomData.getAllTasks()
    }

    override suspend fun getTaskById(taskId: String): Task? {
        return locaRoomData.getTask(taskId)
    }

    override suspend fun saveTask(task: Task) {
        locaRoomData.saveTask(task)
    }

    override suspend fun saveAllTasks(task: List<Task>) {
        locaRoomData.saveAllTasks(task)
    }

    override suspend fun deleteTask(task: Task) {
        locaRoomData.deleteTask(task)
    }
}