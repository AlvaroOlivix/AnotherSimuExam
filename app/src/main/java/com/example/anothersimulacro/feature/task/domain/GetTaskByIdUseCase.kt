package com.example.anothersimulacro.feature.task.domain

import org.koin.core.annotation.Single

@Single
class GetTaskByIdUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskId: String): Task? {
        return taskRepository.getTaskById(taskId)
    }
}