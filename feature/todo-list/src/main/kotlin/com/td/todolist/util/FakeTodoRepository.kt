package com.td.todolist.util

import com.td.data.repository.TodoRepository
import com.td.database.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeTodoRepository : TodoRepository {
    private val _todos = MutableStateFlow<List<Todo>>(listOf(
        Todo(id = 1, title = "Sample Todo 1"),
        Todo(id = 2, title = "Sample Todo 2")
    ))
    override suspend fun upsertTodo(todo: Todo) {
        _todos.value = _todos.value + todo
    }

    override suspend fun deleteTodo(todo: Todo) {

        _todos.value = _todos.value.filter { it.id != todo.id }
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return _todos.value.find { it.id == id }
    }

    override fun getTodos(): Flow<List<Todo>> = _todos
}