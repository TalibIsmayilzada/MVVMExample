package com.talib.mvvmexample.data

class FolderRepository(val dao: NotesDatabseDAO) {


    suspend fun insertFolder(folderModel: FolderModel){
        dao.insertFolder(folderModel)
    }

    suspend fun updateFolder(folderModel: FolderModel){
        dao.updateFolder(folderModel)
    }

    suspend fun deleteFolder(folderModel: FolderModel){
        dao.deleteFolder(folderModel)
    }

    fun getCurrentFoldersList() = dao.getAllFolderList()

    suspend fun insertNotes(notesModel: NotesModel){
        dao.insertNotes(notesModel)
    }

    suspend fun updateNotes(notesModel: NotesModel){
        dao.updateNotes(notesModel)
    }

    suspend fun deleteNotes(notesModel: NotesModel){
        dao.deleteNotes(notesModel)
    }

    fun getCurrentNotesList(folderID: Int) = dao.getAllNotesList(folderID)
}