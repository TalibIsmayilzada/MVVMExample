package com.talib.mvvmexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NotesModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val folderID: Int,
    val title: String,
    val desc: String,
    val image: String? = null
)