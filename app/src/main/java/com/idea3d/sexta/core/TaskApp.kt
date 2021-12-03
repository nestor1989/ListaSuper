package com.idea3d.sexta.core

import android.app.Application
import androidx.room.Room
import com.idea3d.sexta.data.model.TaskDb

class TaskApp: Application() {

    companion object {
        lateinit var database: TaskDb

    }

    override fun onCreate() {
        super.onCreate()
        TaskApp.database = Room
                .databaseBuilder(this, TaskDb::class.java, "task")
                .build()
    }
}