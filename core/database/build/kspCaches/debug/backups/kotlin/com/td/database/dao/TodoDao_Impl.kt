package com.td.database.dao

import android.database.Cursor
import android.os.CancellationSignal
import androidx.room.CoroutinesRoom
import androidx.room.CoroutinesRoom.Companion.execute
import androidx.room.EntityDeletionOrUpdateAdapter
import androidx.room.EntityInsertionAdapter
import androidx.room.EntityUpsertionAdapter
import androidx.room.RoomDatabase
import androidx.room.RoomSQLiteQuery
import androidx.room.RoomSQLiteQuery.Companion.acquire
import androidx.room.util.createCancellationSignal
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.query
import androidx.sqlite.db.SupportSQLiteStatement
import com.td.database.model.Todo
import java.lang.Class
import java.util.ArrayList
import java.util.concurrent.Callable
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class TodoDao_Impl(
  __db: RoomDatabase,
) : TodoDao {
  private val __db: RoomDatabase

  private val __deletionAdapterOfTodo: EntityDeletionOrUpdateAdapter<Todo>

  private val __upsertionAdapterOfTodo: EntityUpsertionAdapter<Todo>
  init {
    this.__db = __db
    this.__deletionAdapterOfTodo = object : EntityDeletionOrUpdateAdapter<Todo>(__db) {
      protected override fun createQuery(): String = "DELETE FROM `Todo` WHERE `id` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Todo) {
        val _tmpId: Int? = entity.id
        if (_tmpId == null) {
          statement.bindNull(1)
        } else {
          statement.bindLong(1, _tmpId.toLong())
        }
      }
    }
    this.__upsertionAdapterOfTodo = EntityUpsertionAdapter<Todo>(object :
        EntityInsertionAdapter<Todo>(__db) {
      protected override fun createQuery(): String =
          "INSERT INTO `Todo` (`title`,`id`) VALUES (?,?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Todo) {
        statement.bindString(1, entity.title)
        val _tmpId: Int? = entity.id
        if (_tmpId == null) {
          statement.bindNull(2)
        } else {
          statement.bindLong(2, _tmpId.toLong())
        }
      }
    }, object : EntityDeletionOrUpdateAdapter<Todo>(__db) {
      protected override fun createQuery(): String =
          "UPDATE `Todo` SET `title` = ?,`id` = ? WHERE `id` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Todo) {
        statement.bindString(1, entity.title)
        val _tmpId: Int? = entity.id
        if (_tmpId == null) {
          statement.bindNull(2)
        } else {
          statement.bindLong(2, _tmpId.toLong())
        }
        val _tmpId_1: Int? = entity.id
        if (_tmpId_1 == null) {
          statement.bindNull(3)
        } else {
          statement.bindLong(3, _tmpId_1.toLong())
        }
      }
    })
  }

  public override suspend fun deleteTodo(todo: Todo): Unit = CoroutinesRoom.execute(__db, true,
      object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __deletionAdapterOfTodo.handle(todo)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun upsertTodo(todo: Todo): Unit = CoroutinesRoom.execute(__db, true,
      object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __upsertionAdapterOfTodo.upsert(todo)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun getTodoById(id: Int): Todo? {
    val _sql: String = "SELECT * FROM todo WHERE id = ?"
    val _statement: RoomSQLiteQuery = acquire(_sql, 1)
    var _argIndex: Int = 1
    _statement.bindLong(_argIndex, id.toLong())
    val _cancellationSignal: CancellationSignal? = createCancellationSignal()
    return execute(__db, false, _cancellationSignal, object : Callable<Todo?> {
      public override fun call(): Todo? {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_cursor, "title")
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _result: Todo?
          if (_cursor.moveToFirst()) {
            val _tmpTitle: String
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle)
            val _tmpId: Int?
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId)
            }
            _result = Todo(_tmpTitle,_tmpId)
          } else {
            _result = null
          }
          return _result
        } finally {
          _cursor.close()
          _statement.release()
        }
      }
    })
  }

  public override fun getTodos(): Flow<List<Todo>> {
    val _sql: String = "SELECT * FROM todo"
    val _statement: RoomSQLiteQuery = acquire(_sql, 0)
    return CoroutinesRoom.createFlow(__db, false, arrayOf("todo"), object : Callable<List<Todo>> {
      public override fun call(): List<Todo> {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_cursor, "title")
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _result: MutableList<Todo> = ArrayList<Todo>(_cursor.getCount())
          while (_cursor.moveToNext()) {
            val _item: Todo
            val _tmpTitle: String
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle)
            val _tmpId: Int?
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId)
            }
            _item = Todo(_tmpTitle,_tmpId)
            _result.add(_item)
          }
          return _result
        } finally {
          _cursor.close()
        }
      }

      protected fun finalize() {
        _statement.release()
      }
    })
  }

  public companion object {
    @JvmStatic
    public fun getRequiredConverters(): List<Class<*>> = emptyList()
  }
}
