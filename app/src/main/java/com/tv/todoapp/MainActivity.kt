package com.tv.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import com.td.designssystem.theme.TodoAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.td.todolist.TodoListScreen
import com.td.todolist.addtodo.AddTodoScreen
import com.td.todolist.util.UiEvent

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "todo_list") {
                    composable("todo_list") {
                        TodoListScreen(onNavigate = { event ->
                            when (event) {
                                is UiEvent.Navigate -> navController.navigate(event.route)
                            }
                        })
                    }
                    composable("add_todo") {
                        AddTodoScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}

