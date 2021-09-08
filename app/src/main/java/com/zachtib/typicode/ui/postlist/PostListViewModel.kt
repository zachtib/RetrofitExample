package com.zachtib.typicode.ui.postlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zachtib.typicode.data.TypicodeRepository
import com.zachtib.typicode.models.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

sealed class PostListState {
    object Loading : PostListState()
    data class Error(val errorMessage: String) : PostListState()
    data class PostsLoaded(val posts: List<Post>) : PostListState()
}

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val repository: TypicodeRepository,
) : ViewModel() {
    private val mutableState = MutableLiveData<PostListState>()

    val state: LiveData<PostListState>
        get() = mutableState

    init {
        viewModelScope.launch {
            mutableState.postValue(PostListState.Loading)

            try {
                val posts = repository.getPostsList()
                mutableState.postValue(PostListState.PostsLoaded(posts))
            } catch (e: Exception) {
                mutableState.postValue(PostListState.Error("Something went wrong."))
            }
        }
    }
}