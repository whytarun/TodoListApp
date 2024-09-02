import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.td.todolist.TodoListViewModel
import com.td.todolist.util.FakeTodoRepository
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertFalse

@ExperimentalCoroutinesApi
class TodoListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TodoListViewModel
    private lateinit var fakeRepository: FakeTodoRepository

    private val testDispatcher: TestDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeTodoRepository()
        viewModel = TodoListViewModel(fakeRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test initial state is not empty list`() = runTest {
        val todos = viewModel.filteredTodos.first()
        assertFalse(todos.isEmpty(), "The todos list should not be empty")
    }
}
