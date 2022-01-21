package com.idea3d.sexta.data.model


import androidx.room.*


@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val taskId:Int=0,
    @ColumnInfo(name="nombre_task")
    val name:String="",
    var isDone:Boolean=false

)

@Entity
data class Art(
    @PrimaryKey(autoGenerate = true)
                val artId:Int=0,
    @ColumnInfo(name="nombre_art")
                val name:String="",
                var isDone:Boolean=false)

data class TaskYArts (
    @Embedded val task: Task,
    @Relation(
         parentColumn = "taskId",
         entityColumn = "artId",
    )
    val art: MutableList<Art>
)