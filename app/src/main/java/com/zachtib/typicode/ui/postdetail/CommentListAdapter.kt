package com.zachtib.typicode.ui.postdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zachtib.typicode.databinding.CommentListItemBinding
import com.zachtib.typicode.models.Comment

class CommentListAdapter : ListAdapter<Comment, CommentListAdapter.CommentViewHolder>(
    CommentsCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = CommentListItemBinding.inflate(inflater, parent, false)

        return CommentViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = getItem(position)
        holder.bind(comment)
    }

    class CommentViewHolder(
        private val itemBinding: CommentListItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(comment: Comment) = with(itemBinding) {
            commentName.text = comment.name
            commentEmail.text = comment.email
            commentBody.text = comment.body
        }
    }

    companion object {
        object CommentsCallback : DiffUtil.ItemCallback<Comment>() {
            override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem == newItem
            }
        }
    }
}