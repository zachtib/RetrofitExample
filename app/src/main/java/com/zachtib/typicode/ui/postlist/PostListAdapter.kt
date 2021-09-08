package com.zachtib.typicode.ui.postlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zachtib.typicode.databinding.PostListItemBinding
import com.zachtib.typicode.models.Post


class PostListAdapter(
    private val onItemClicked: (Post) -> Unit
) : ListAdapter<Post, PostListAdapter.PostViewHolder>(PostItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = PostListItemBinding.inflate(inflater, parent, false)

        return PostViewHolder(itemBinding, onItemClicked)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }

    class PostViewHolder(
        private val itemBinding: PostListItemBinding,
        private val itemClickedCallback: (Post) -> Unit
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(post: Post) = with(itemBinding) {
            titleTextView.text = post.title
            root.setOnClickListener {
                itemClickedCallback(post)
            }
        }
    }

    companion object {
        object PostItemCallback : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }
        }
    }
}