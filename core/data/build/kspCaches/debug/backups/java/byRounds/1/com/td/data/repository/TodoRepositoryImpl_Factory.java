package com.td.data.repository;

import com.td.database.db.TodoDatabase;
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
public final class TodoRepositoryImpl_Factory implements Factory<TodoRepositoryImpl> {
  private final Provider<TodoDatabase> databaseProvider;

  public TodoRepositoryImpl_Factory(Provider<TodoDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TodoRepositoryImpl get() {
    return newInstance(databaseProvider.get());
  }

  public static TodoRepositoryImpl_Factory create(Provider<TodoDatabase> databaseProvider) {
    return new TodoRepositoryImpl_Factory(databaseProvider);
  }

  public static TodoRepositoryImpl newInstance(TodoDatabase database) {
    return new TodoRepositoryImpl(database);
  }
}
