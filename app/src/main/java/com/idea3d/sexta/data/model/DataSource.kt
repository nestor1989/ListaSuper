package com.idea3d.sexta.data.model

import com.idea3d.sexta.vo.Resource

class DataSource(private val taskDb: TaskDb) {


     suspend fun insertTask(task: Task) {
        taskDb.taskDao().addTask(task)
    }

    suspend fun getAllTask(): Resource<List<Task>>{
        return Resource.Success(taskDb.taskDao().getAllTask())
    }

    suspend fun deleteArt(art:Art){
        taskDb.taskDao().deleteArt(art)
    }

    suspend fun getArtByTaskId(taskId:Long):Resource<List<Art>>{
        return Resource.Success(taskDb.taskDao().getArtByTaskId(taskId))
    }

    suspend fun getArtById(id:Long):Art{
        return taskDb.taskDao().getArtById(id)
    }

     suspend fun insertArt(art: Art){
         taskDb.taskDao().addArt(art)
    }

    suspend fun updateArt(art: Art){
        taskDb.taskDao().updateArt(art)
    }
}