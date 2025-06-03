package com.enesturkoglu.pawtrackv2.repo

import com.enesturkoglu.pawtrackv2.data.dao.TaskDao
import com.enesturkoglu.pawtrackv2.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao:TaskDao){

    fun getAllTasks():Flow<List<TaskEntity>>{

        return taskDao.getAllTasks()
    }
    suspend fun addTask(task:TaskEntity){
        taskDao.insertTask(task)
    }
}