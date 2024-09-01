package com.td.todolist.addtodo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.td.data.repository.TodoRepository
import com.td.database.model.Todo
import com.td.todolist.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) :ViewModel()  {

    var todo by mutableStateOf<Todo?>(null)
        private set

    var title by mutableStateOf("")
    private set

    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: AddTodoEvent) {
        when(event) {
            is AddTodoEvent.OnTitleChange -> {
                title = event.title
            }
            is AddTodoEvent.OnSaveTodoClick -> {
                viewModelScope.launch {
                    if(title.isBlank()) {
                        sendUiEvent(UiEvent.ShowSnackbar(
                            message = "The title can't be empty"
                        ))
                        return@launch
                    }
                    if (title == "Error") {
                        sendUiEvent(UiEvent.ShowSnackbar("Failed to add TODO"))
                        sendUiEvent(UiEvent.PopBackStack)
                        return@launch
                    }
                    todoRepository.upsertTodo(
                        Todo(
                            title = title,
                            id = todo?.id
                        )
                    )
                    sendUiEvent(UiEvent.PopBackStack)
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}