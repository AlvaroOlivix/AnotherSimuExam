package com.example.anothersimulacro.feature.task.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anothersimulacro.feature.task.domain.GetTaskByIdUseCase
import com.example.anothersimulacro.feature.task.domain.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class TaskDetailViewModel(private val getTaskByIdUseCase: GetTaskByIdUseCase) : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> get() = _uiState

    fun loadTask(taskId: String) {
        _uiState.value = UiState(loading = true)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val taskLoaded = getTaskByIdUseCase(taskId)
                _uiState.postValue(UiState(task = taskLoaded))
            } catch (e: Exception) {
                _uiState.postValue(UiState(error = true))
                Log.e("@dev", e.message.toString())
            }

        }
    }

    data class UiState(
        val task: Task? = null,
        val loading: Boolean = false,
        val error: Boolean = false,
    )
}