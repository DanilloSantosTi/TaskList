package core

import data.Task
import java.time.format.DateTimeFormatter

object Tools {
    fun Task.formatToString(): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
        val createdAtFormatted = getCreatedAt().format(formatter)

        return """
        ID: ${getId()}
        Título: $title
        Descrição: ${description ?: "Nenhuma"}
        Concluída: ${if (isCompleted) "Sim" else "Não"}
        Criada em: $createdAtFormatted
    """.trimIndent()
    }

    fun MutableList<Task>.getAllTaskCompleted(list: MutableList<Task>): String {

        val taskCompleted = mutableListOf<Task>()

        list.forEach { task ->
            if (task.isCompleted) {
                taskCompleted.add(task)
            }
        }
        return "Total de tarefas concluídas: ${taskCompleted.size}"
    }
}