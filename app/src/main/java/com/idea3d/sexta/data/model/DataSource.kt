package com.idea3d.sexta.data.model

import com.idea3d.sexta.vo.Resource

class DataSource {
    private val generateTask = mutableListOf<Task>()


    fun getTaskRes(): Resource<MutableList<Task>> {
        return Resource.Success(generateTask)
    }
}