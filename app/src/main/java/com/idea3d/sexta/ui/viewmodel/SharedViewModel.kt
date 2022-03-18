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


    var taskId=MutableLiveData<Long>()

    fun getAllTask()= liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repo.getAllTask())
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }

    fun onTask(task:Task){
        taskId.value=task.taskId
    }

    fun addTask(task: Task) {
    viewModelScope.launch {
        repo.addTask(task)
        onTask(task)
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

    fun deleteArt(art:Art){
        viewModelScope.launch{
            repo.deleteArt(art)
        }
    }

    fun addArt(art: Art){
        viewModelScope.launch {
           /* val id = repo.addArt(art)
            val recoveryArt = TaskApp.database.taskDao().getArtById(id)*/
            repo.addArt(art)
        }
    }



    fun updateArt(art: Art) {
        viewModelScope.launch {
            repo.updateArt(art)
        }
    }

    val getArtByTaskId= liveData(Dispatchers.IO) {
        //emit(Resource.Loading())
        try {
            emit(repo.getArtByTaskId(taskId.value!!))
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }

}