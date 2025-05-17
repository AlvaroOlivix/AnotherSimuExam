package com.example.anothersimulacro.feature.task.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.anothersimulacro.databinding.ItemTaskBinding
import com.example.anothersimulacro.feature.task.domain.Task

class TasksAdapter() : ListAdapter<Task, TasksViewHolder>(TasksDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task = getItem(position)
        holder.bindEachTask(task)
    }
}