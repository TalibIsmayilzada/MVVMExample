package com.talib.mvvmexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "folders")
data class FolderModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String
)
