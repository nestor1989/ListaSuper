package com.idea3d.sexta.core

import android.app.Application
import androidx.room.Room
import com.idea3d.sexta.data.model.ArtDb
import com.idea3d.sexta.data.model.TaskDb

class TaskApp: Application() {

    companion object {
        lateinit var database: TaskDb
        lateinit var databaseArt: ArtDb
    }

    override fun onCreate() {
        super.onCreate()
        TaskApp.database = Room
                .databaseBuilder(this, TaskDb::class.java, "task")
                .build()

        TaskApp.databaseArt = Room
            .databaseBuilder(this, ArtDb::class.java, "art")
            .build()

    }
}