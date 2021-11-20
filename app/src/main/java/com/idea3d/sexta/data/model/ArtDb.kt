package com.idea3d.sexta.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.idea3d.sexta.domain.ArtDao

@Database(
    entities= [Art::class],
    version=1
)
abstract class ArtDb:RoomDatabase() {
    abstract fun artDao() : ArtDao

}