package br.com.gdc.feature.data.entity.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.gdc.feature.data.entity.TaskDto

@Dao
interface TaskDAO {
    @Query("SELECT * FROM task_table ORDER BY name ASC")
    fun getAllTaks() : LiveData<List<TaskDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // corrotinas
    suspend fun insert(taskDto: TaskDto)
}