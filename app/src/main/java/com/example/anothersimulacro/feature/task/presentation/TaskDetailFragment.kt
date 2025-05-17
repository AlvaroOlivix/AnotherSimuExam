package com.example.anothersimulacro.feature.task.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.anothersimulacro.databinding.FragmentDetailTaskBinding
import com.example.anothersimulacro.feature.task.domain.Task
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskDetailFragment : Fragment() {
    private var _binding: FragmentDetailTaskBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TaskDetailViewModel by viewModel()

    private val args: TaskDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailTaskBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObserver()
        viewModel.loadTask(args.taskId)
    }


    private fun setUpObserver() {
        val observer = Observer<TaskDetailViewModel.UiState>() {
            if (it.loading) {
                Log.d("@dev", "Lista de task cargando")
            }
            if (it.error) {
                Log.d("@dev", "Error cargando la lista de tasks")
            }
            bindData(it.task)
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun bindData(task: Task?) {
        binding.apply {
            if (task != null) {
                state.text = task.state.nombre
                descripcion.text = task.name
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}