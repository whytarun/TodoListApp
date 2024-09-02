package com.td.todolist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.td.todolist.util.FakeTodoRepository
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class TodoListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSearchTextFieldDisplayed() {
        val fakeRepository = FakeTodoRepository()
        val viewModel = TodoListViewModel(fakeRepository)

        // Set the content for the Composable
        composeTestRule.setContent {
            TodoListScreen(onNavigate = {}, viewModel = viewModel)
        }

        // Check if the search text field is displayed
        composeTestRule.onNodeWithText("Search")
            .assertIsDisplayed()
    }
}