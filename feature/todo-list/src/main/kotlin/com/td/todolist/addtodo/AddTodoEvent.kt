package com.td.todolist.addtodo

sealed class AddTodoEvent {
    data class OnTitleChange(val title: String): AddTodoEvent()
    object OnSaveTodoClick: AddTodoEvent()
}