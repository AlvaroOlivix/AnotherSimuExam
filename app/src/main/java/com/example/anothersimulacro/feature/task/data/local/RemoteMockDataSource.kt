package com.example.anothersimulacro.feature.task.data.local

import com.example.anothersimulacro.feature.task.domain.State
import com.example.anothersimulacro.feature.task.domain.Task
import org.koin.core.annotation.Single

@Single
class RemoteMockDataSource {
    private val stateList = listOf(
        State("a1", "Dele"),
        State("a2", "D2"),
        State("a3", "D3"),
    )
    private val examplesTasks = listOf(
        Task("id", "Comprar", stateList[1]),
        Task("id2", "Comprar Carne", stateList[2]),
        Task("id3", "Comprar Fruta", stateList[0])
    )

    fun getAll(): List<Task> {
        return examplesTasks
    }

    fun getTaskById(taskId: String): Task? {
        return examplesTasks.find { it.id == taskId }
    }
}