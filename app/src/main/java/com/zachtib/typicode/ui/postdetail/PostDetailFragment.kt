package com.zachtib.typicode.ui.postdetail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zachtib.typicode.R
import com.zachtib.typicode.databinding.PostDetailFragmentBinding
import com.zachtib.typicode.models.Comment
import com.zachtib.typicode.models.Post
import com.zachtib.typicode.models.User
import com.zachtib.typicode.ui.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostDetailFragment : Fragment(R.layout.post_detail_fragment) {
    private val binding by viewBinding(PostDetailFragmentBinding::bind)
    private val args by navArgs<PostDetailFragmentArgs>()
    private val viewModel by viewModels<PostDetailViewModel>()

    private val commentAdapter = CommentListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.postCommentsRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = commentAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
            isNestedScrollingEnabled = false
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.loadPost(args.postId)

        viewModel.state.observe(this) { state ->
            when (state) {
                PostDetailState.Loading -> showLoading()
                is PostDetailState.Error -> showError(state.errorMessage)
                is PostDetailState.ContentLoaded -> showContent(
                    state.post,
                    state.author,
                    state.comments
                )
            }
        }
    }

    private fun showLoading() = with(binding) {
        loadingIndicator.isVisible = true
        contentScrollView.isVisible = false
        errorMessage.isVisible = false
    }

    private fun showError(message: String) = with(binding) {
        loadingIndicator.isVisible = false
        contentScrollView.isVisible = false
        errorMessage.run {
            isVisible = true
            text = message
        }
    }

    private fun showContent(post: Post, author: User, comments: List<Comment>) = with(binding) {
        loadingIndicator.isVisible = false
        contentScrollView.isVisible = true
        errorMessage.isVisible = false

        postTitle.text = post.title
        authorName.text = author.username
        postBody.text = post.body
        commentAdapter.submitList(comments)
    }
}