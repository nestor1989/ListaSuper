package com.idea3d.sexta.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Art(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name:String="",
    var isDone:Boolean=false

)
