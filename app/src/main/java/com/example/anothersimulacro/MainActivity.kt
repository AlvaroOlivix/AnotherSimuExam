package com.example.anothersimulacro

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.anothersimulacro.core.db.RoomProvider
import com.example.anothersimulacro.core.db.TaskDataBase
import com.example.anothersimulacro.feature.task.data.TaskDataRepository
import com.example.anothersimulacro.feature.task.data.local.RemoteMockDataSource
import com.example.anothersimulacro.feature.task.data.local.room.LocalRoomTaskDataSource
import com.example.anothersimulacro.feature.task.data.local.room.TaskDao
import com.example.anothersimulacro.feature.task.domain.State
import com.example.anothersimulacro.feature.task.domain.Task
import com.example.anothersimulacro.feature.task.domain.UpdateTaskUseCase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //setTestData()
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun setTestData() {

        GlobalScope.launch {
            //Creacion del database e instanciacion de repository.
            val db = RoomProvider.providerDb(this@MainActivity)
            val taskDao = db.taskDao()
            val localRoomDataSource = LocalRoomTaskDataSource(taskDao)
            val remoteData = RemoteMockDataSource()
            val repo = TaskDataRepository(localRoomDataSource, remoteData)
            val updateTaskUseCase = UpdateTaskUseCase(repo)

            // 2) Inserta datos de ejemplo
            val stateList = listOf(
                State("a1", "Dele"),
                State("a2", "D2"),
                State("a3", "D3"),
            )
            val examplesTasks = listOf(
                Task("id", "Comprar", stateList[1]),
                Task("id2", "Comprar Carne", stateList[2]),
                Task("id3", "Comprar Fruta", stateList[0])
            )
            // 3) Prueba de funciones definidas
            repo.saveAllTasks(examplesTasks)
            Log.d("dev", repo.getAllTasks().toString())

            val tskCreated = Task("id4", "Comprar Moto", stateList[0])
            repo.saveTask(tskCreated)
            Log.d("dev", repo.getTaskById("id4").toString())
            Log.d("dev", repo.getAllTasks().toString())

            val task = repo.getTaskById(tskCreated.id)
            task?.let {
                updateTaskUseCase.invoke(task, stateList[2])
            }
            val taskUpdated = repo.getTaskById(tskCreated.id)
            Log.d("dev", taskUpdated.toString())

        }

    }
}