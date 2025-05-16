package com.example.anothersimulacro.feature.task.data

import com.example.anothersimulacro.feature.task.data.local.room.LocalRoomTaskDataSource
import com.example.anothersimulacro.feature.task.domain.Task
import com.example.anothersimulacro.feature.task.domain.TaskRepository

class TaskDataRepository(private val locaRoomData: LocalRoomTaskDataSource) : TaskRepository {
    override fun getAllTasks(): List<Task> {
        return locaRoomData.getAllTasks()
    }

    override fun getTaskById(taskId: String): Task? {
        return locaRoomData.getTask(taskId)
    }

    override fun saveTask(task: Task) {
        locaRoomData.saveTask(task)
    }

    override fun saveAllTasks(task: List<Task>) {
        locaRoomData.saveAllTasks(task)
    }

    override fun deleteTask(task: Task) {
        locaRoomData.deleteTask(task)
    }
}