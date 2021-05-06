package com.talib.mvvmexample.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NotesDatabseDAO {

    @Insert
    suspend fun insertFolder(folderModel: FolderModel)

    @Update
    suspend fun updateFolder(folderModel: FolderModel)

    @Delete
    suspend fun deleteFolder(folderModel: FolderModel)

    @Query("SELECT * FROM folders")
    fun getAllFolderList(): LiveData<List<FolderModel>>


    @Insert
    suspend fun insertNotes(notesModel: NotesModel)

    @Update
    suspend fun updateNotes(notesModel: NotesModel)

    @Delete
    suspend fun deleteNotes(notesModel: NotesModel)

    @Query("SELECT * FROM notes WHERE folderID == :folID")
    fun getAllNotesList(folID: Int): LiveData<List<NotesModel>>

}