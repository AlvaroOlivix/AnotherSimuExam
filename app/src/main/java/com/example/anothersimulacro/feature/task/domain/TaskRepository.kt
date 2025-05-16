package com.example.anothersimulacro.feature.task.domain

interface TaskRepository {
    fun getAllTasks(): List<Task>
    fun getTaskById(taskId:String): Task?
    fun saveTask(task: Task)
    fun saveAllTasks(task: List<Task>)
    fun deleteTask(task: Task)
}