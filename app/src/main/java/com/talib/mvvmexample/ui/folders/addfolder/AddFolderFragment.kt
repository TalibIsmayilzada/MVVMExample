package com.talib.mvvmexample.ui.folders.addfolder

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.talib.mvvmexample.R
import com.talib.mvvmexample.data.FolderModel
import com.talib.mvvmexample.ui.MainActivity


class AddFolderFragment : Fragment(R.layout.fragment_add_folder) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn: Button = view.findViewById(R.id.saveFolder)
        val folderTitle: EditText = view.findViewById(R.id.folderTitle)

        btn.setOnClickListener {
            if (folderTitle.text.trim().isNotEmpty()){
                saveFolder(folderTitle.text.trim().toString())
            }else{
                Toast.makeText(requireContext(),"Please enter title",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveFolder(title: String){
        val folderModel = FolderModel(null,title)
        (activity as MainActivity).folderViewModel.insertFolder(folderModel)
        activity?.onBackPressed()
    }


}