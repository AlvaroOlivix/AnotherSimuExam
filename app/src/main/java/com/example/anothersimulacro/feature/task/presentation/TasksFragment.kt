package com.example.anothersimulacro.feature.task.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anothersimulacro.databinding.FragmentTaskListBinding
import com.example.anothersimulacro.feature.task.presentation.adapter.TasksAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TasksFragment() : Fragment() {

    private var _binding: FragmentTaskListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TasksViewModel by viewModel()
    private lateinit var adapter:TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TasksAdapter()
        setUpObserver()
        setUpRecycler()
        viewModel.loadTaskList()
    }

    private fun setUpObserver() {
        val observer = Observer<TasksViewModel.UiState>() {
            if (it.loading) {
                Log.d("@dev", "Lista de task cargando")
            }
            if (it.error) {
                Log.d("@dev", "Error cargando la lista de tasks")
            }
            adapter.submitList(it.tasks)
            /*
            it.tasks.forEach { task ->
                Log.d("@dev", "Tarea ${task.id}:  ${task.name}")
            }
            */
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun setUpRecycler() {
        binding.apply {
            recyclerTasks.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerTasks.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}