package com.idea3d.sexta.ui.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.idea3d.sexta.data.model.Task

import com.idea3d.sexta.domain.Repo


import kotlinx.coroutines.launch


class SharedViewModel(private val repo: Repo): ViewModel() {

fun crearTask(){
    viewModelScope.launch{
        repo.insertTask()
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