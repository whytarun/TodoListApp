package com.td.data.repository

import com.td.database.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun upsertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)

    suspend fun getTodoById(id: Int): Todo?

    fun getTodos(): Flow<List<Todo>>
}