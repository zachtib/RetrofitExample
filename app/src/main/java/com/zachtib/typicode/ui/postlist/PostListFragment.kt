package com.zachtib.typicode.ui.postlist

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.zachtib.typicode.R
import com.zachtib.typicode.databinding.PostListFragmentBinding
import com.zachtib.typicode.ui.viewBinding

class PostListFragment: Fragment(R.layout.post_list_fragment) {

    private val binding by viewBinding(PostListFragmentBinding::bind)
    private val viewModel by viewModels<PostListViewModel>()

    override fun onStart() {
        super.onStart()
    }
}