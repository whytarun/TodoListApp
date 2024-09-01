package com.td.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    val title: String,
    @PrimaryKey val id: Int? = null
)
