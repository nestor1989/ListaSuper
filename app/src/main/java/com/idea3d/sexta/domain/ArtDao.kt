package com.idea3d.sexta.domain

import androidx.room.*
import com.idea3d.sexta.data.model.Art

@Dao
interface ArtDao {
    @Query("SELECT * FROM Art")
    fun getAll(): MutableList<Art>

    @Query("SELECT * FROM Art where id like :id")
    fun getById(id: Long): Art

    @Insert
    fun addArt(artEntity: Art): Long

    @Update
    fun updateArt(artEntity: Art): Int

    @Delete
    fun deleteArt(artEntity: Art):Int
}