package com.idea3d.sexta.domain

import com.idea3d.sexta.data.model.Art
import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.data.model.TaskYArts
import kotlinx.coroutines.flow.Flow


interface Repo {
     fun getAll(): Flow<List<Task>>

     suspend fun getById(id:Long): Task?

     suspend fun addTask(taskEntity : Task):Long

     suspend fun updateTask(taskEntity: Task):Int

     suspend fun deleteTask(taskEntity: Task):Int

     fun getAllArt(): Flow<List<Art>>

     suspend fun getArtById(id:Long): Art

     fun getTaskYArts(): List<TaskYArts>

     suspend fun addArt(artEntity : Art):Long

     suspend fun updateArt(artEntity: Art):Int

     suspend fun deleteArt(artEntity: Art):Int

}