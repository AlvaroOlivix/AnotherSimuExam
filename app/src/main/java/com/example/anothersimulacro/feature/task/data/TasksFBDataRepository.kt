package com.example.anothersimulacro.feature.task.data

import com.example.anothersimulacro.feature.task.data.remote.RemoteFBDataSource
import com.example.anothersimulacro.feature.task.domain.Task
import com.example.anothersimulacro.feature.task.domain.TaskRepository

class TasksFBDataRepository(private val remoteData: RemoteFBDataSource) : TaskRepository {
    override suspend fun getAllTasks(): List<Task> {
        return remoteData.getAllTasks()
    }

    override suspend fun getTaskById(taskId: String): Task? {
        TODO("Not yet implemented")
    }

    override suspend fun saveTask(task: Task) {
        remoteData.saveTask(task)
    }

    override suspend fun saveAllTasks(tasks: List<Task>) {
        remoteData.saveAllTasks(tasks)
    }

    override suspend fun deleteTask(task: Task) {
        remoteData.deleteTask(task.id)
    }

}