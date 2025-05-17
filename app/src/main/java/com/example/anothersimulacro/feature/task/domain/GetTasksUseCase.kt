package com.example.anothersimulacro.feature.task.domain

import org.koin.core.annotation.Single

@Single
class GetTasksUseCase(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(): List<Task> {
        return taskRepository.getAllTasks()
    }
}