package com.example.anothersimulacro.feature.task.data.local.room

import com.example.anothersimulacro.feature.task.domain.Task

fun Task.toEntity() = TaskEntity(id = this.id, name = this.name, state = this.state)
fun TaskEntity.toModel() = Task(id = this.id, name = this.name, state = this.state)