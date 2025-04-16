import core.TaskManagerImpl
import core.Result
import core.Tools.formatToString
import java.util.UUID

fun main() {
    val taskManager = TaskManagerImpl()
    var running = true

    while (running) {
        println("\n--- Gerenciador de Tarefas ---")
        println("Escolha uma opção:")
        println("1. Criar nova tarefa")
        println("2. Listar todas as tarefas")
        println("3. Marcar tarefa como concluída/não concluída")
        println("4. Excluir tarefa")
        println("5. Filtrar tarefas por status")
        println("0. Sair")
        print("--> ")

        when (readlnOrNull()) {
            "1" -> {
                val result = taskManager.createTask()
                when (result) {
                    is Result.Success -> println(result.success)
                    is Result.Failure -> println("Erro ao criar tarefa: ${result.exception.message}")
                    else -> println("Resultado inesperado.")
                }
            }
            "2" -> {
                val result = taskManager.allTasks()
                when (result) {
                    is Result.Success -> println("--- Todas as Tarefas ---\n${result.success}")
                    is Result.Failure -> println("Erro ao listar tarefas: ${result.exception.message}")
                    else -> println("Resultado inesperado.")
                }
            }
            "3" -> {
                println("Digite o ID da tarefa que deseja atualizar:")
                print("--> ")
                val taskIdInput = readlnOrNull()
                if (!taskIdInput.isNullOrBlank()) {
                    try {
                        val taskId = UUID.fromString(taskIdInput)
                        val task = taskManager.getTask(taskId)
                        if (task != null) {
                            println("Tarefa encontrada: ${task.title}")
                            println("Marcar como concluída? (s/n)")
                            print("--> ")
                            when (readlnOrNull()?.lowercase()) {
                                "s" -> taskManager.updateStatusTask(taskId, true)
                                "n" -> taskManager.updateStatusTask(taskId, false)
                                else -> println("Opção inválida.")
                            }
                        } else {
                            println("Tarefa com ID: $taskId não encontrada.")
                        }
                    } catch (e: IllegalArgumentException) {
                        println("ID inválido.")
                    }
                } else {
                    println("ID da tarefa não pode ser vazio.")
                }
            }
            "4" -> {
                println("Digite o ID da tarefa que deseja excluir:")
                print("--> ")
                val taskIdInput = readlnOrNull()
                if (!taskIdInput.isNullOrBlank()) {
                    try {
                        val taskId = UUID.fromString(taskIdInput)
                        taskManager.deleteTask(taskId)
                    } catch (e: IllegalArgumentException) {
                        println("ID inválido.")
                    } catch (e: IllegalStateException) {
                        println(e.message)
                    }
                } else {
                    println("ID da tarefa não pode ser vazio.")
                }
            }
            "5" -> {
                println("Filtrar tarefas por status:")
                println("1. Concluídas")
                println("2. Não concluídas")
                print("--> ")
                when (readlnOrNull()) {
                    "1" -> {
                        val tasksConcluidas = taskManager.filterTasks(true)
                        if (tasksConcluidas.isNotEmpty()) {
                            println("--- Tarefas Concluídas ---")
                            tasksConcluidas.forEach { println(it.formatToString()) }
                        } else {
                            println("Nenhuma tarefa concluída.")
                        }
                    }
                    "2" -> {
                        val tasksNaoConcluidas = taskManager.filterTasks(false)
                        if (tasksNaoConcluidas.isNotEmpty()) {
                            println("--- Tarefas Não Concluídas ---")
                            tasksNaoConcluidas.forEach { println(it.formatToString()) }
                        } else {
                            println("Nenhuma tarefa não concluída.")
                        }
                    }
                    else -> println("Opção inválida.")
                }
            }
            "0" -> running = false
            else -> println("Opção inválida. Tente novamente.")
        }
    }

    println("Saindo do Gerenciador de Tarefas.")
}