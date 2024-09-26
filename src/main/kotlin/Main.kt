package de.azxn

data class Task(val id: Int, val description: String, var isDone: Boolean = false)

class TodoList {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    fun addTask(description: String) {
        tasks.add(Task(nextId++, description))
    }

    fun markTaskAsDone(id: Int) {
        tasks.find { it.id == id }?.isDone = true
    }

    fun removeTask(id: Int) {
        tasks.removeIf { it.id == id }
    }

    fun listTasks() {
        tasks.forEach { task ->
            val status = if (task.isDone) "Done" else "Pending"
            println("Task ${task.id}: ${task.description} - $status")
        }
    }
}

fun main() {
    val todoList = TodoList()
    todoList.addTask("Learn Kotlin")
    todoList.addTask("Write a simple To-Do list")
    todoList.listTasks()
    todoList.markTaskAsDone(1)
    println("\nAfter marking task 1 as done:")
    todoList.listTasks()
    todoList.removeTask(2)
    println("\nAfter removing task 2:")
    todoList.listTasks()
}