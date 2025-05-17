package com.example.anothersimulacro.feature.task.presentation.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.anothersimulacro.databinding.ItemTaskBinding
import com.example.anothersimulacro.feature.task.domain.Task

class TasksViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
    fun bindEachTask(task: Task) {
        binding.apply {
            tarea.text = task.name
            descripcion.text = task.state.nombre
        }
    }
}