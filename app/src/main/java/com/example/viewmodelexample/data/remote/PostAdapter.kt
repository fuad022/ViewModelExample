package com.example.viewmodelexample.data.remote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelexample.data.remote.model.PostModel
import com.example.viewmodelexample.databinding.RowLayoutBinding

class PostAdapter : ListAdapter<PostModel, PostAdapter.ItemHolder>(DiffCallback()) {

    class ItemHolder(private val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostModel) {
            /*binding.userIdTxt.text = post.userId.toString()
            binding.idTxt.text = post.id.toString()*/
            binding.apply {
                titleTxt.text = post.title
                bodyTxt.text = post.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            RowLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<PostModel>() {
        override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel) =
            oldItem.userId == newItem.userId

        override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel) =
            oldItem == newItem
    }

    override fun submitList(list: MutableList<PostModel>?) {
        super.submitList(list?.map { it.copy() })
    }
}


















