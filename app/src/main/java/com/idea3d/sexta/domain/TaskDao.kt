package com.idea3d.sexta.domain

import androidx.room.*
import com.idea3d.sexta.data.model.Art

import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.data.model.TaskYArts


@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    suspend fun getAllTask(): List<Task>

    @Query("SELECT * FROM Task where taskId like :id")
    suspend fun getById(id:Long): Task

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTask(taskEntity : Task):Long

    @Update
    suspend fun updateTask(taskEntity: Task):Int

    @Delete
    suspend fun deleteTask(taskEntity: Task):Int

    @Query ("SELECT * FROM Art")
     fun getAllArt():MutableList<Art>

    @Query ("SELECT * FROM Art where artId like:id")
     fun getArtById(id:Long): Art

    @Transaction
    @Query("SELECT * FROM Task")
    suspend fun getTaskYArts(): List<TaskYArts>

    @Insert
    fun addArt(artEntity : Art):Long

    @Update
     fun updateArt(artEntity: Art):Int

    @Delete
     fun deleteArt(artEntity: Art):Int



}