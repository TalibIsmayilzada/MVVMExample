package com.talib.mvvmexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.talib.mvvmexample.R
import java.lang.StringBuilder

class NotesFragment : Fragment(R.layout.fragment_notes) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notesTextView = view.findViewById<TextView>(R.id.notes)

        arguments?.getInt("folderID")?.let {folderID->
            (activity as MainActivity).folderViewModel.getNotesList(folderID).observe(viewLifecycleOwner,{notes->
                notes?.let {
                    val stringBuilder = StringBuilder()
                    for (i in it){
                        stringBuilder.append(i.title)
                        stringBuilder.append("\n")
                    }
                    notesTextView.text = stringBuilder
                }

            })
        }


    }

}