package br.com.gdc.feature.presenter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.gdc.base.AppDatabase
import br.com.gdc.feature.data.entity.TaskDto
import br.com.gdc.feature.data.entity.local.TaskDAO
import br.com.gdc.feature.data.entity.local.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskListViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository
    val alltasks: LiveData<List<TaskDto>>

    init {
        val dao : TaskDAO = AppDatabase.getDatabase(application).taskDao()
        repository = TaskRepository.create(dao)
        alltasks = repository.getAllTask()
    }

    fun addTask(taskDto: TaskDto) {
        viewModelScope.launch {
            repository.addTask(taskDto)
        }
    }

    class  TaskViewModelFactory constructor(private val application: Application) :
            ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if(modelClass.isAssignableFrom((TaskListViewModel::class.java))) {
                TaskListViewModel(this.application) as T
            } else {
                throw  IllegalArgumentException("ViewModel Not Found")
            }
         }
            }
}