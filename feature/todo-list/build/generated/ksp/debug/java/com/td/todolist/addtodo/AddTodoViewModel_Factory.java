package com.td.todolist.addtodo;

import com.td.data.repository.TodoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AddTodoViewModel_Factory implements Factory<AddTodoViewModel> {
  private final Provider<TodoRepository> todoRepositoryProvider;

  public AddTodoViewModel_Factory(Provider<TodoRepository> todoRepositoryProvider) {
    this.todoRepositoryProvider = todoRepositoryProvider;
  }

  @Override
  public AddTodoViewModel get() {
    return newInstance(todoRepositoryProvider.get());
  }

  public static AddTodoViewModel_Factory create(Provider<TodoRepository> todoRepositoryProvider) {
    return new AddTodoViewModel_Factory(todoRepositoryProvider);
  }

  public static AddTodoViewModel newInstance(TodoRepository todoRepository) {
    return new AddTodoViewModel(todoRepository);
  }
}
