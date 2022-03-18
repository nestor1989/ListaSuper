package com.idea3d.sexta.domain

import androidx.room.*
import com.idea3d.sexta.data.model.Art

import com.idea3d.sexta.data.model.Task



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
    suspend fun getAllArt():MutableList<Art>

    @Query ("SELECT * FROM Art where artId like:id")
    suspend fun getArtById(id:Long): Art

    @Query ("SELECT * FROM Art where id_task like:id")
    suspend fun getArtByTaskId(id:Long):List<Art>

    /*@Transaction
    @Query("SELECT * FROM Art where taskId")
    suspend fun getTaskYArts(): List<TaskYArts>*/

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArt(artEntity : Art):Long

    @Update
    suspend fun updateArt(artEntity: Art):Int

    @Delete
    suspend fun deleteArt(artEntity: Art):Int



}