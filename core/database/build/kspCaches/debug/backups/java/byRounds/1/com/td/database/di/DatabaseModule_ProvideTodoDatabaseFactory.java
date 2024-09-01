package com.td.database.di;

import android.app.Application;
import com.td.database.db.TodoDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideTodoDatabaseFactory implements Factory<TodoDatabase> {
  private final DatabaseModule module;

  private final Provider<Application> appProvider;

  public DatabaseModule_ProvideTodoDatabaseFactory(DatabaseModule module,
      Provider<Application> appProvider) {
    this.module = module;
    this.appProvider = appProvider;
  }

  @Override
  public TodoDatabase get() {
    return provideTodoDatabase(module, appProvider.get());
  }

  public static DatabaseModule_ProvideTodoDatabaseFactory create(DatabaseModule module,
      Provider<Application> appProvider) {
    return new DatabaseModule_ProvideTodoDatabaseFactory(module, appProvider);
  }

  public static TodoDatabase provideTodoDatabase(DatabaseModule instance, Application app) {
    return Preconditions.checkNotNullFromProvides(instance.provideTodoDatabase(app));
  }
}
