package com.idea3d.sexta.domain

import androidx.room.*
import com.idea3d.sexta.data.model.Art

import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.data.model.TaskYArts
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAll(): Flow<List<Task>>

    @Query("SELECT * FROM Task where taskId like :id")
    suspend fun getById(id:Long): Task?

    @Insert
    suspend fun addTask(taskEntity : Task):Long

    @Update
    suspend fun updateTask(taskEntity: Task):Int

    @Delete
    suspend fun deleteTask(taskEntity: Task):Int

    @Query ("SELECT * FROM Art")
    fun getAllArt():Flow<List<Art>>

    @Query ("SELECT * FROM Art where artId like:id")
    suspend fun getArtById(id:Long): Art

    @Transaction
    @Query("SELECT * FROM Task")
    fun getTaskYArts(): List<TaskYArts>

    @Insert
    suspend fun addArt(artEntity : Art):Long

    @Update
    suspend fun updateArt(artEntity: Art):Int

    @Delete
    suspend fun deleteArt(artEntity: Art):Int



}