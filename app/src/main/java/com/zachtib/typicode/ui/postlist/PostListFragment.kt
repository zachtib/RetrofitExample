package com.zachtib.typicode.ui.postlist

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zachtib.typicode.R
import com.zachtib.typicode.databinding.PostListFragmentBinding
import com.zachtib.typicode.models.Post
import com.zachtib.typicode.ui.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostListFragment: Fragment(R.layout.post_list_fragment) {

    private val binding by viewBinding(PostListFragmentBinding::bind)
    private val viewModel by viewModels<PostListViewModel>()
    private val postAdapter = PostListAdapter(::navigateToPostDetailScreen)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            postRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            postRecyclerView.adapter = postAdapter
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.state.observe(this) { state ->
            when (state) {
                PostListState.Loading -> showLoading()
                is PostListState.Error -> showError(state.errorMessage)
                is PostListState.PostsLoaded -> showPosts(state.posts)
            }
        }
    }

    private fun showLoading() = with(binding) {
        loadingIndicator.isVisible = true
        postRecyclerView.isVisible = false
        errorMessage.isVisible = false
    }

    private fun showError(message: String) = with(binding) {
        loadingIndicator.isVisible = false
        postRecyclerView.isVisible = false
        errorMessage.run {
            isVisible = true
            text = message
        }
    }

    private fun showPosts(posts: List<Post>) = with(binding) {
        loadingIndicator.isVisible = false
        postRecyclerView.isVisible = true
        errorMessage.isVisible = false

        postAdapter.submitList(posts)
    }

    private fun navigateToPostDetailScreen(post: Post) {
        val action = PostListFragmentDirections.toPostDetailFragment(postId = post.id)
        findNavController().navigate(action)
    }
}