package com.idea3d.sexta.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.idea3d.sexta.domain.TaskDao

@Database(
    entities= [Task::class, Art::class],
    version=1
)
abstract class TaskDb:RoomDatabase() {

    abstract fun taskDao() : TaskDao

    companion object{
        private var INSTANCE: TaskDb?=null

        fun getDataBase(context: Context):TaskDb{
            INSTANCE=INSTANCE?: Room.databaseBuilder(context.applicationContext, TaskDb::class.java, "task").build()
            return INSTANCE!!
        }
    }

}