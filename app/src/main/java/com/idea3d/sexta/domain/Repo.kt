package com.idea3d.sexta.domain

import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.data.model.Art
import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.vo.Resource

interface Repo {
    suspend fun addTask(task:Task)
    suspend fun addArt (art:Art)
    suspend fun updateTask(task:Task)
    suspend fun deleteTask(task:Task)
    suspend fun addTasks(task:Task)

}