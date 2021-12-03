package com.idea3d.sexta.ui.viewmodel
import androidx.lifecycle.*
import com.idea3d.sexta.data.model.Art

import com.idea3d.sexta.data.model.Task

import com.idea3d.sexta.domain.Repo


import kotlinx.coroutines.launch


class SharedViewModel(private val repo: Repo): ViewModel() {

val allTask: MutableLiveData<Task> by lazy {
    MutableLiveData<Task>()
}

 fun addTask(task: Task){
    viewModelScope.launch{
        repo.addTask(task)
    }
}

fun addArt(art: Art){
    viewModelScope.launch{
        repo.addArt(art)
    }
}


    fun addTasks(task: Task){
    viewModelScope.launch {
        repo.addTasks(task)
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



    /*val fetchTask = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(repo.getTaskList())
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }*/



}