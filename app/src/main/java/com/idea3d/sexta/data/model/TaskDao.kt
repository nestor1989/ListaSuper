package com.idea3d.sexta.data.model

import androidx.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAll():MutableList<Task>

    @Query("SELECT * FROM Task where id like :id")
    fun getById(id:Long):Task

    @Insert
    fun addTask(taskEntity : Task):Long

    @Update
    fun updateTask(taskEntity: Task):Int

    @Delete
    fun deleteTask(taskEntity: Task):Int


}