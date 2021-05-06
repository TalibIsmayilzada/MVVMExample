package com.talib.mvvmexample.ui.folders

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.talib.mvvmexample.data.FolderModel
import com.talib.mvvmexample.data.FolderRepository
import com.talib.mvvmexample.data.NotesModel
import kotlinx.coroutines.launch

class FolderViewModel(private val repository: FolderRepository) : ViewModel() {

    val folders = repository.getCurrentFoldersList()

    fun insertFolder(folderModel: FolderModel) = viewModelScope.launch {
        repository.insertFolder(folderModel)
    }

    fun updateFolder(folderModel: FolderModel) = viewModelScope.launch {
        repository.updateFolder(folderModel)
    }

    fun deleteFolder(folderModel: FolderModel) = viewModelScope.launch {
        repository.deleteFolder(folderModel)
    }

    fun getNotesList(folderId : Int): LiveData<List<NotesModel>> = repository.getCurrentNotesList(folderId)

    fun insertNote(notesModel: NotesModel) = viewModelScope.launch {
        repository.insertNotes(notesModel)
    }

}