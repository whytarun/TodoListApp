package com.td.data.di

import com.td.data.repository.TodoRepository
import com.td.data.repository.TodoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindTodoRepository(impl: TodoRepositoryImpl): TodoRepository

}