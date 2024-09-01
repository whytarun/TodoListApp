package com.td.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.td.data.repository.TodoRepository
import com.td.database.model.Todo
import com.td.todolist.util.Routes
import com.td.todolist.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
): ViewModel() {

    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos.asStateFlow()

    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val _filteredTodos = MutableStateFlow<List<Todo>>(emptyList())
    val filteredTodos: StateFlow<List<Todo>> = _filteredTodos.asStateFlow()

    // State to manage search query
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {

        viewModelScope.launch {
            repository.getTodos()
                .collect { todos ->
                    _todos.value = todos
                    filterTodos(_searchQuery.value)
                }
        }
    }

    fun onEvent(event: TodoListEvent) {
        when(event) {
            is TodoListEvent.OnTodoClick -> {
                //sendUiEvent(UiEvent.Navigate(Routes.ADD_TODO + "?todoId=${event.todo.id}"))
            }
            is TodoListEvent.OnAddTodoClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_TODO))
            }

            is TodoListEvent.OnSearchQueryChange -> {
                _searchQuery.value = event.query
                filterTodos(event.query)
            }
        }
    }
    private fun filterTodos(query: String) {
        _filteredTodos.value = _todos.value.filter { todo ->
            todo.title.contains(query, ignoreCase = true)
        }
        println("vales...."+_filteredTodos.value)
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}