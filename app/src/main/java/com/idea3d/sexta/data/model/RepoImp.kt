package com.idea3d.sexta.data.model

import com.idea3d.sexta.domain.Repo
import com.idea3d.sexta.vo.Resource

class RepoImp (private val dataSource: DataSource):Repo  {
    override suspend fun getTaskList(): Resource<List<Task>> {
        return dataSource.getTaskRes()
    }

    override suspend fun insertTask() {

    }


}