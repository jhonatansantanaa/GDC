package br.com.gdc.feature.data.entity.local.repository

import androidx.lifecycle.LiveData
import br.com.gdc.feature.data.entity.TaskDto
import br.com.gdc.feature.data.entity.local.TaskDAO

class TaskRepository private constructor(
    private val localDataSource: TaskDAO
){

    suspend fun addTask(taskDto: TaskDto) {
        localDataSource.insert(taskDto)
    }

    fun getAllTask() : LiveData<List<TaskDto>> = localDataSource.getAllTaks()

    companion object {
        fun create(localDataSource: TaskDAO) : TaskRepository {
            return TaskRepository(localDataSource)
        }
    }

}