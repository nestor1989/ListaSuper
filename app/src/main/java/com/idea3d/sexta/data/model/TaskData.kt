package com.idea3d.sexta.data.model


import androidx.room.*


@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var taskId:Long=0,
    @ColumnInfo(name="nombre_task")
    val name:String="",
    @ColumnInfo(name="is_done")
    var isDone:Boolean=false

)

@Entity
data class Art(
    @PrimaryKey(autoGenerate = true)
    var artId:Long=0,
    @ColumnInfo(name="nombre_art")
    val name:String="",
    @ColumnInfo(name="id_task")
    val taskId: Long,
    @ColumnInfo(name="is_done")
    var isDone:Boolean=false
)

/*data class TaskYArts (
    @Embedded val task: Task,
    @Relation(
         parentColumn = "taskId",
         entityColumn = "taskId"
    )
    val art: MutableList<Art>
)*/