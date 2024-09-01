package com.td.todolist;

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
public final class TodoListViewModel_Factory implements Factory<TodoListViewModel> {
  private final Provider<TodoRepository> repositoryProvider;

  public TodoListViewModel_Factory(Provider<TodoRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TodoListViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static TodoListViewModel_Factory create(Provider<TodoRepository> repositoryProvider) {
    return new TodoListViewModel_Factory(repositoryProvider);
  }

  public static TodoListViewModel newInstance(TodoRepository repository) {
    return new TodoListViewModel(repository);
  }
}
