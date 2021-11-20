package com.idea3d.sexta.domain

import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.vo.Resource

interface Repo {
    suspend fun getTaskList(): Resource<List<Task>>
    suspend fun insertTask ()
}