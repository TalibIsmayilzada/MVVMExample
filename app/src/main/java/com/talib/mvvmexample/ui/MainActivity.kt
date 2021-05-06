package com.talib.mvvmexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.talib.mvvmexample.R
import com.talib.mvvmexample.data.FolderRepository
import com.talib.mvvmexample.data.NotesDatabase
import com.talib.mvvmexample.data.NotesModel
import com.talib.mvvmexample.ui.folders.FolderViewModel
import com.talib.mvvmexample.ui.folders.FolderViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var folderViewModel: FolderViewModel
    private lateinit var folderViewModelFactory: FolderViewModelFactory
    private lateinit var repository: FolderRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = NotesDatabase.getDatabase(this).notesDao()
        repository = FolderRepository(dao)
        folderViewModelFactory = FolderViewModelFactory(repository)
        folderViewModel = ViewModelProvider(this,folderViewModelFactory).get(FolderViewModel::class.java)





    }
}