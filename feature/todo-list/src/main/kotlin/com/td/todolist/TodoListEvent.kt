package com.td.todolist

import com.td.database.model.Todo


sealed class TodoListEvent {
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
    data class OnSearchQueryChange(val query: String): TodoListEvent()
}