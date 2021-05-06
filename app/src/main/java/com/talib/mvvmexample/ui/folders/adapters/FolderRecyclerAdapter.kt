package com.talib.mvvmexample.ui.folders.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.talib.mvvmexample.data.FolderModel
import com.talib.mvvmexample.databinding.FoldersRecyclerItemBinding

class FolderRecyclerAdapter: RecyclerView.Adapter<FolderRecyclerAdapter.FolderRecyclerViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<FolderModel>() {
        override fun areItemsTheSame(oldItem: FolderModel, newItem: FolderModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FolderModel, newItem: FolderModel): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FoldersRecyclerItemBinding.inflate(inflater,parent,false)
        return FolderRecyclerViewHolder(binding,onItemClickListener)
    }

    override fun onBindViewHolder(holder: FolderRecyclerViewHolder, position: Int) {
        holder.bind(differ.currentList.getOrNull(position))
    }

    override fun getItemCount(): Int = differ.currentList.size


    inner class FolderRecyclerViewHolder(val itemBinding: FoldersRecyclerItemBinding,onItemClickListener: ((FolderModel) -> Unit)?) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(folderModel: FolderModel?){
            itemBinding.folderName.text = folderModel?.title
            itemBinding.root.setOnClickListener {
                folderModel?.let {folder->
                    onItemClickListener?.invoke(folder)
                }
            }
        }
    }

    private var onItemClickListener: ((FolderModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (FolderModel) -> Unit) {
        onItemClickListener = listener
    }
}