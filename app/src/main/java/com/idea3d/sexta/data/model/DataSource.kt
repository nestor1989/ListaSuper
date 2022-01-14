package com.idea3d.sexta.data.model

import com.idea3d.sexta.core.TaskApp

class DataSource() {


     suspend fun getTaskRes(task: Task) {
        TaskApp.database.taskDao().addTask(task)
    }


     suspend fun insertArt(art: Art){
        TaskApp.database.taskDao().addArt(art)
    }

}