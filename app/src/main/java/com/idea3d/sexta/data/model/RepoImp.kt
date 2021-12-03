package com.idea3d.sexta.data.model

import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.domain.Repo
import com.idea3d.sexta.ui.adapters.TasksAdapter

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class RepoImp (private val dataSource: DataSource):Repo  {


//    val allTask: MutableList<Task> = TaskApp.database.taskDao().getAll()

     lateinit var tasks:MutableList<Task>

    override suspend fun addTask(task: Task){
        return dataSource.getTaskRes(task)
    }

    override suspend fun addArt(art:Art) {
        dataSource.insertArt(art)
    }


    override suspend fun updateTask(task: Task) {

        doAsync {
            task.isDone = !task.isDone
            TaskApp.database.taskDao().updateTask(task)
        }
    }

    override suspend fun deleteTask(task: Task){
        doAsync {
            val position = tasks.indexOf(task)
            TaskApp.database.taskDao().deleteTask(task)
            tasks.remove(task)
            uiThread {
               // adapter.notifyItemRemoved(position)
            }
        }
    }
    override suspend fun addTasks(task: Task) {

        tasks= TaskApp.database.taskDao().getAll()

       doAsync {

            val id = TaskApp.database.taskDao().addTask(task)
            val recoveryTask = TaskApp.database.taskDao().getById(id)
            uiThread {

                tasks.add(recoveryTask)

                //clearFocus()

            }
        }
    }



}