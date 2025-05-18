package com.example.anothersimulacro.feature.task.data.remote

import com.example.anothersimulacro.feature.task.domain.State
import com.example.anothersimulacro.feature.task.domain.Task
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import org.koin.core.annotation.Single

@Single
class RemoteFBDataSource(private val firestore: FirebaseFirestore) {
    private val taskCol = firestore.collection("tasks")
    private val stateCol = firestore.collection("states")

    suspend fun saveAllTasks(tasks: List<Task>) {

        tasks.forEach { task ->
            val stateId = task.state.id
            taskCol
                .document(task.id)
                .set(task.toEntity(stateId))
                .await()
        }
    }

    suspend fun saveAllStates(states: List<State>) {

        states.forEach { state ->
            stateCol
                .document(state.id)
                .set(state.toEntity())
                .await()
        }
    }

    suspend fun saveTask(task: Task) {
        taskCol
            .document(task.id)
            .set(task.toEntity(task.state.id))
            .await()
    }


    suspend fun getStateById(stateId: String): State? {
        val docSnap = stateCol.document(stateId).get().await()
        val entity = docSnap.toObject(StateEntityFs::class.java) ?: return null
        return entity.toModel()
    }


    suspend fun deleteTask(taskId: String) {
        firestore.collection("tasks").document(taskId).delete().await()
    }

    private suspend fun getAllStates(): List<State> {
        val snap = firestore.collection("states").get().await()
        return snap.documents
            .mapNotNull { it.toObject(StateEntityFs::class.java) }
            .map { it.toModel() }
    }

    suspend fun getAllTasks(): List<Task> {
        val taskCol = firestore.collection("tasks")
        val allStates = getAllStates()
        val snap = taskCol.get().await()
        return snap.documents
            .mapNotNull { it.toObject(TaskEntityFs::class.java) }
            .map { entity ->
                // Busca el State correspondiente; si no existe, usa un por defecto
                val state = allStates.find { it.id == entity.stateId }
                    ?: State(id = entity.stateId, nombre = "Desconocido")
                entity.toModel(state)
            }
    }
}



