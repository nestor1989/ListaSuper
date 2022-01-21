package com.idea3d.sexta.data.model

import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.domain.Repo
import com.idea3d.sexta.ui.adapters.TasksAdapter
import com.idea3d.sexta.vo.Resource

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class RepoImp (private val dataSource: DataSource):Repo {

    override suspend fun getAllTask(): Resource<List<Task>> {
        return dataSource.getAllTask()
    }

    override suspend fun addTask(task: Task) {
        dataSource.insertTask(task)
    }

    override suspend fun addArt(art: Art) {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(task: Task) {
        TODO("Not yet implemented")
    }


}