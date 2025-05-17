package com.example.anothersimulacro.feature.task.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.anothersimulacro.feature.task.domain.Task

class TasksDiffUtil : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}