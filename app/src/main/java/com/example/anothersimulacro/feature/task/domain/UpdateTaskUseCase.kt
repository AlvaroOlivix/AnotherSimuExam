package com.example.anothersimulacro.feature.task.domain

class UpdateTaskUseCase(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(task: Task, newState: State){
        val newTask = task.copy(state = newState)
        taskRepository.saveTask(newTask)
    }
}