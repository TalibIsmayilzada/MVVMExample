package com.talib.mvvmexample.ui.folders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.talib.mvvmexample.data.FolderRepository

class FolderViewModelFactory(val repository: FolderRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FolderViewModel(repository) as T
    }
}