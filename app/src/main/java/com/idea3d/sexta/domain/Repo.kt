package com.idea3d.sexta.domain

import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.data.model.Art
import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.vo.Resource

interface Repo {
    suspend fun getAllTask():Resource<List<Task>>
    suspend fun getArtByTaskId(taskId:Long):Resource<List<Art>>
    suspend fun getArtById(id:Long):Art
    suspend fun addTask(task:Task)
    suspend fun addArt (art:Art)
    suspend fun updateTask(task:Task)
    suspend fun deleteTask(task:Task)
    suspend fun deleteArt(art:Art)
    suspend fun updateArt(art: Art)


}