package com.enesturkoglu.pawtrackv2.screens.tasks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enesturkoglu.pawtrackv2.data.PetDatabaseInstance
import com.enesturkoglu.pawtrackv2.data.model.TaskEntity
import com.enesturkoglu.pawtrackv2.repo.TaskRepository
import kotlinx.coroutines.launch

class TaskScreenViewModel(aplication:Application):AndroidViewModel(aplication){

    val repository = TaskRepository(PetDatabaseInstance.getDatabase(aplication).taskDao())

    val tasks = repository.getAllTasks()

    fun addTask(taskEntity:TaskEntity){
        viewModelScope.launch {
            repository.addTask(taskEntity)
        }
    }

}