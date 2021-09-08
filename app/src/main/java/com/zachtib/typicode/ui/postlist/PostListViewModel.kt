package com.zachtib.typicode.ui.postlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zachtib.typicode.models.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PostListState {
    object Loading : PostListState()
    data class Error(val errorMessage: String) : PostListState()
    data class PostsLoaded(val posts: List<Post>) : PostListState()
}

@HiltViewModel
class PostListViewModel @Inject constructor() : ViewModel() {
    private val mutableState = MutableLiveData<PostListState>()

    val state: LiveData<PostListState>
        get() = mutableState

    init {
        viewModelScope.launch {
            mutableState.postValue(PostListState.Loading)

            mutableState.postValue(PostListState.PostsLoaded(listOf(
                Post(1, "Hello, World"),
                Post(2, "Hello, Android"),
                Post(3, "Hello, Internet"),
            )))
        }
    }
}