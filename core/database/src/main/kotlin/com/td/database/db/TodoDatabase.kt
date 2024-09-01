package com.td.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.td.database.dao.TodoDao
import com.td.database.model.Todo

@Database(
    entities = [Todo::class],
    version = 1
)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun dao(): TodoDao

    companion object{
        const val NAME ="todo_db"
    }
}