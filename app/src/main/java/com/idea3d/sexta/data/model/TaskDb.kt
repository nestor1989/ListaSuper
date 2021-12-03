package com.idea3d.sexta.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.idea3d.sexta.domain.TaskDao

@Database(
    entities= [Task::class, Art::class],
    version=1
)
abstract class TaskDb:RoomDatabase() {
    abstract fun taskDao() : TaskDao

}