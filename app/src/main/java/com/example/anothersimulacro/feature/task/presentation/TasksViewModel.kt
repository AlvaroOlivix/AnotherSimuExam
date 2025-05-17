package com.example.anothersimulacro.feature.task.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anothersimulacro.feature.task.domain.GetTasksUseCase
import com.example.anothersimulacro.feature.task.domain.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class TasksViewModel(private val getTasksUseCase: GetTasksUseCase) : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> get() = _uiState

    fun loadTaskList() {
        _uiState.value = UiState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val listLoaded = getTasksUseCase()
                _uiState.postValue(UiState(tasks = listLoaded))
                Log.d("@dev", "Lista cargada: $listLoaded")
            } catch (e: Exception) {
                _uiState.postValue(UiState(error = true))
                Log.e("@dev", e.message.toString())
            }
        }
    }


    data class UiState(
        val tasks: List<Task> = emptyList(),
        val loading: Boolean = false,
        val error: Boolean = false,
    )

}