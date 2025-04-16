package core

import core.Tools.formatToString
import data.Task
import java.util.*

class TaskManagerImpl : TaskManager {

    private val listTasks = mutableListOf<Task>()

    override fun createTask(): Result {
        println("Digite o nome da tarefa(task)")
        print("-->")
        val nameTask = readlnOrNull() ?: return Result.Failure(
            Exception("Nome da tarefa não pode ser nulo.")
        )

        require(nameTask.isNotEmpty()) {
            Result.Failure(
                Exception("O nome não pode ser nulo ou vazio")
            )

        }
        println("Digite a descricao da tarefa(task)")
        print("-->")
        val descriptionTask = readln()
        listTasks.add(
            Task(
                title = nameTask,
                description = descriptionTask,
                isCompleted = false,
            )
        )
        return Result.Success("Nova tarefa criada com sucesso!")
    }

    override fun allTasks(): Result {

        val listTaskFormatted = mutableListOf<String>()

        listTasks.forEach { task ->
            listTaskFormatted.add(
                task.formatToString()
            )
        }

        return Result.Success(listTaskFormatted.joinToString())
    }

    override fun getTask(id: UUID): Task? {
        return listTasks.find { it.getId() == id }
    }

    override fun updateStatusTask(id: UUID, isComplete: Boolean) {
        val index = getPositionInList(id)
        require(index != -1) { "Task com ID: $id não encontrada." }

        println("Atualizando tarefa...")
        val updatedTask = listTasks[index].copy(isCompleted = isComplete)
        listTasks[index] = updatedTask
        println("Tarefa atualizada com sucesso!")
    }

    override fun deleteTask(id: UUID) {
        val index = getPositionInList(id)
        require(index != -1) { "Task com ID: $id não encontrada." }

        println("Removando tarefa...")
        listTasks.removeAt(index)
        println("Tarefa removida com sucesso!")
        return

    }

    override fun filterTasks(isComplete: Boolean): List<Task> {
        return listTasks.filter { isComplete }
    }

    override fun getPositionInList(id: UUID): Int {
        return listTasks.indexOfFirst { it.getId() == id }
    }
}