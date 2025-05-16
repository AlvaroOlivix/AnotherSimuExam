package com.example.anothersimulacro.feature.task.data.local.room

import com.example.anothersimulacro.feature.task.domain.Task

class LocalRoomTaskDataSource(private val taskDao: TaskDao) {
    fun getAllTasks(): List<Task> {
        return taskDao.getAll().map { it.toModel() }
    }

    fun getTask(taskId: String): Task? {
        return taskDao.getTaskById(taskId)?.toModel()
    }

    fun saveTask(task: Task) {
        taskDao.saveTask(task.toEntity())
    }

    fun saveAllTasks(tasks: List<Task>) {
        taskDao.saveAllTasks(*tasks.map { it.toEntity() }.toTypedArray())
    }

    fun deleteTask(task: Task) {
        taskDao.delete(task.toEntity())
    }

}