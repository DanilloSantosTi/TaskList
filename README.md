# 📝 TaskList

Uma aplicação de linha de comando em Kotlin para gerenciamento de tarefas, permitindo a criação, listagem, atualização, exclusão e filtragem de tarefas de forma eficiente.

## 🚀 Funcionalidades

- **Criar Tarefa:** Adicione novas tarefas com título e descrição.
- **Listar Tarefas:** Visualize todas as tarefas com seus detalhes.
- **Buscar por ID:** Encontre uma tarefa específica utilizando seu ID único.
- **Atualizar Status:** Marque tarefas como concluídas ou pendentes.
- **Excluir Tarefa:** Remova tarefas da lista pelo ID.
- **Filtrar Tarefas:** Visualize apenas tarefas concluídas ou pendentes.
- **Validações:** Garante que o título da tarefa não seja vazio e que operações sejam realizadas apenas em tarefas existentes.
- **Retornos Tipados:** Utiliza `sealed class` para representar os resultados das operações (`Success` ou `Failure`).
- **Funções de Extensão:** Métodos adicionais para formatar tarefas e contar tarefas concluídas.

## 🛠️ Tecnologias Utilizadas

- **Kotlin:** Linguagem principal do projeto.
- **Paradigma Orientado a Objetos:** Estruturação do código baseada em classes e objetos.
- **Funções de Extensão:** Métodos adicionais para classes existentes.
- **Sealed Classes:** Representação de resultados de operações de forma segura e tipada.

## 📁 Estrutura do Projeto

```
TaskList/
├── src/
│   ├── core/
│   │   ├── TaskManager.kt
│   │   ├── TaskManagerImpl.kt
│   │   └── Tools.kt
│   └── data/
│       ├── Task.kt
│       └── Result.kt
├── .gitignore
└── README.md
```

## 📦 Como Executar

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/DanilloSantosTi/TaskList.git
   ```

2. **Navegue até o diretório do projeto:**

   ```bash
   cd TaskList
   ```

3. **Compile e execute o projeto:**

   Utilize sua IDE preferida (como IntelliJ IDEA) para abrir o projeto e executar a aplicação.

## 💡 Exemplos de Uso

### Criando uma tarefa:

```kotlin
val taskManager = TaskManagerImpl()
val result = taskManager.createTask() // será solicitado nome e descrição pelo terminal
println(result)
```

### Listando tarefas:

```kotlin
val result = taskManager.allTasks()
println(result)
```

### Atualizando uma tarefa:

```kotlin
val id: UUID = ... // UUID de uma tarefa existente
taskManager.updateStatusTask(id, isComplete = true)
```

### Excluindo uma tarefa:

```kotlin
val id: UUID = ... // UUID de uma tarefa existente
taskManager.deleteTask(id)
```

### Filtrando tarefas:

```kotlin
val completedTasks = taskManager.filterTasks(isComplete = true)
val pendingTasks = taskManager.filterTasks(isComplete = false)
```

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

