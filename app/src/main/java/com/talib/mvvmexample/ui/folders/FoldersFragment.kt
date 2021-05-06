package com.talib.mvvmexample.ui.folders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.talib.mvvmexample.R
import com.talib.mvvmexample.data.FolderModel
import com.talib.mvvmexample.databinding.FragmentFoldersBinding
import com.talib.mvvmexample.ui.MainActivity
import com.talib.mvvmexample.ui.folders.adapters.FolderRecyclerAdapter


class FoldersFragment : Fragment() {

    private lateinit var binding: FragmentFoldersBinding

    private lateinit var folderAdapter: FolderRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_folders, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        folderAdapter = FolderRecyclerAdapter()

        folderAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                it.id?.let { it1 -> putInt("folderID", it1) }
            }
            findNavController().navigate(R.id.action_foldersFragment_to_notesFragment,bundle)
        }


        binding.foldersRV.apply {
            adapter = folderAdapter
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_foldersFragment_to_addFolderFragment)
        }
        (activity as MainActivity).folderViewModel.folders.observe(viewLifecycleOwner,{list->

            list?.let {
                folderAdapter.differ.submitList(list)
            }

        })

    }

}