package com.idea3d.sexta.data.model

import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.domain.Repo
import com.idea3d.sexta.domain.TaskDao
import com.idea3d.sexta.ui.adapters.TasksAdapter
import kotlinx.coroutines.flow.Flow

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class RepoImp (private val taskDao: TaskDao):Repo  {


//    val allTask: MutableList<Task> = TaskApp.database.taskDao().getAll()


    override fun getAll(): Flow<List<Task>> {
        return taskDao.getAll()
    }

    override suspend fun getById(id: Long): Task? {
        return taskDao.getById(id)
    }

    override suspend fun addTask(task: Task):Long{
        return taskDao.addTask(task)
    }

    override fun getAllArt(): Flow<List<Art>> {
        return taskDao.getAllArt()
    }

    override suspend fun getArtById(id: Long): Art {
        return taskDao.getArtById(id)
    }

    override fun getTaskYArts(): List<TaskYArts> {
        return taskDao.getTaskYArts()
    }

    override suspend fun updateArt(artEntity: Art): Int {
        return taskDao.updateArt(artEntity)
    }

    override suspend fun deleteArt(artEntity: Art): Int {
        return taskDao.deleteArt(artEntity)
    }

    override suspend fun addArt(art:Art):Long {
        return taskDao.addArt(art)
    }


    override suspend fun updateTask(task: Task):Int {
        return taskDao.updateTask(task)
    }

    override suspend fun deleteTask(task: Task):Int{
        return taskDao.deleteTask(task)
    }
    /*override fun addTasks(task: Task) {

        tasks= TaskApp.database.taskDao().getAll()

       doAsync {

            val id = TaskApp.database.taskDao().addTask(task)
            val recoveryTask = TaskApp.database.taskDao().getById(id)
            uiThread {

                tasks.add(recoveryTask)

                //clearFocus()

            }
        }*/
    }



