package core

import data.Task
import java.util.*

interface TaskManager {
    fun createTask(): Result
    fun allTasks(): Result
    fun getTask(id: UUID): Task?
    fun updateStatusTask(id: UUID, isComplete: Boolean)
    fun deleteTask(id: UUID)
    fun filterTasks(isComplete: Boolean): List<Task>
    fun getPositionInList(id: UUID): Int
}