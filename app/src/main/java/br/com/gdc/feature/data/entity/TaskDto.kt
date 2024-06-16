package br.com.gdc.feature.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskDto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val state: String,
)

enum class Status {
    TODO,
    PROGRESS,
    DONE
}
