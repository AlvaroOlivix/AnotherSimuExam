package com.example.anothersimulacro.feature.task.data.remote

import com.example.anothersimulacro.feature.task.domain.State
import com.example.anothersimulacro.feature.task.domain.Task

fun Task.toEntity(stateId: String): TaskEntityFs = TaskEntityFs(this.id, this.name, stateId)
fun TaskEntityFs.toModel(state: State): Task =
    Task(this.id, this.name, state)

fun State.toEntity(): StateEntityFs = StateEntityFs(this.id, this.nombre)
fun StateEntityFs.toModel(): State = State(this.id, this.nombre)
