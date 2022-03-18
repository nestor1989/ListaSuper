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

    override suspend fun getArtByTaskId(taskId:Long): Resource<List<Art>> {
        return dataSource.getArtByTaskId(taskId)
    }

    override suspend fun getArtById(id: Long): Art {
        return dataSource.getArtById(id)
    }

    override suspend fun addTask(task: Task) {
        dataSource.insertTask(task)
    }

    override suspend fun addArt(art: Art){
         dataSource.insertArt(art)
    }

    override suspend fun updateTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteArt(art: Art) {
        dataSource.deleteArt(art)
    }

    override suspend fun updateArt(art: Art) {
        dataSource.updateArt(art)
    }


}