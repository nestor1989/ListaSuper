package com.idea3d.sexta.ui.viewmodel
import androidx.lifecycle.*
import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.data.model.Art

import com.idea3d.sexta.data.model.Task

import com.idea3d.sexta.domain.Repo
import com.idea3d.sexta.ui.adapters.TasksAdapter
import com.idea3d.sexta.vo.Resource
import kotlinx.coroutines.Dispatchers


import kotlinx.coroutines.launch


class SharedViewModel(private val repo: Repo): ViewModel() {

    fun getAllTask()= liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repo.getAllTask())
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }


    fun addTask(task: Task){
    viewModelScope.launch {
        repo.addTask(task)

        }
    }

    fun updateTask(task: Task){
        viewModelScope.launch {
            repo.updateTask(task)

        }
    }
    fun deleteTask(task: Task){
        viewModelScope.launch {
            repo.deleteTask(task)
        }
    }

}