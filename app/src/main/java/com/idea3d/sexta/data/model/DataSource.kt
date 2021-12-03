package com.idea3d.sexta.data.model

import com.idea3d.sexta.core.TaskApp

class DataSource() {


     fun getTaskRes(task: Task) {
        TaskApp.database.taskDao().addTask(task)
    }


     fun insertArt(art: Art){
        TaskApp.database.taskDao().addArt(art)
    }

}