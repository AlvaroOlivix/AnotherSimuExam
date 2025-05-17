package com.example.anothersimulacro.feature.task.data

import com.example.anothersimulacro.feature.task.data.local.RemoteMockDataSource
import com.example.anothersimulacro.feature.task.data.local.room.LocalRoomTaskDataSource
import com.example.anothersimulacro.feature.task.domain.Task
import com.example.anothersimulacro.feature.task.domain.TaskRepository
import org.koin.core.annotation.Single

@Single
class TaskDataRepository(
    private val locaRoomData: LocalRoomTaskDataSource,
    private val remoteData: RemoteMockDataSource
) : TaskRepository {
    override fun getAllTasks(): List<Task> {
        return remoteData.getAll()
    }

    override fun getTaskById(taskId: String): Task? {
        return remoteData.getTaskById(taskId)
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