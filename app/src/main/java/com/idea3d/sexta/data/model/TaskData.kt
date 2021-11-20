package com.idea3d.sexta.data.model

import android.media.CamcorderProfile.getAll
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.idea3d.sexta.core.TaskApp.Companion.databaseArt

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val recycle: MutableList<String?> = mutableListOf(""),
    val name:String="",
    var isDone:Boolean=false

)
