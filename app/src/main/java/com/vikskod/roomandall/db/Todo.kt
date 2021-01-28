package com.vikskod.roomandall.db

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */

@Entity(tableName = "table_todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String
)