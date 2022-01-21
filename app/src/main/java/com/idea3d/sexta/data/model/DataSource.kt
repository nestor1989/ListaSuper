package com.idea3d.sexta.data.model

import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.vo.Resource

class DataSource() {


     suspend fun insertTask(task: Task) {
        TaskApp.database.taskDao().addTask(task)
    }

    suspend fun getAllTask(): Resource<List<Task>>{
        return Resource.Success(TaskApp.database.taskDao().getAllTask())
    }

     suspend fun insertArt(art: Art){
        TaskApp.database.taskDao().addArt(art)
    }

}