package com.zachtib.typicode.ui.postdetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.zachtib.typicode.R
import com.zachtib.typicode.databinding.PostDetailFragmentBinding
import com.zachtib.typicode.ui.viewBinding

class PostDetailFragment : Fragment(R.layout.post_detail_fragment) {
    private val binding by viewBinding(PostDetailFragmentBinding::bind)
    private val viewModel by viewModels<PostDetailViewModel>()
}