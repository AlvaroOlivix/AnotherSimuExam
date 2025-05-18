package com.example.anothersimulacro.feature.task.domain

interface TaskRepository {
    suspend fun getAllTasks(): List<Task>
    suspend fun getTaskById(taskId:String): Task?
    suspend fun saveTask(task: Task)
    suspend fun saveAllTasks(tasks: List<Task>)
    suspend fun deleteTask(task: Task)
}