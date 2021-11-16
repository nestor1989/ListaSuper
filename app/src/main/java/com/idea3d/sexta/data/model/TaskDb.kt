package com.idea3d.sexta.data.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities= [Task::class],
    version=1
)
abstract class TaskDb:RoomDatabase() {
    abstract fun taskDao() : TaskDao

}