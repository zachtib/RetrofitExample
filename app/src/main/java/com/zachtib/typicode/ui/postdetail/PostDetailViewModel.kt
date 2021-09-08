package com.zachtib.typicode.ui.postdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zachtib.typicode.data.TypicodeRepository
import com.zachtib.typicode.models.Comment
import com.zachtib.typicode.models.Post
import com.zachtib.typicode.models.User
import com.zachtib.typicode.ui.postlist.PostListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

sealed class PostDetailState {
    object Loading : PostDetailState()
    data class Error(val errorMessage: String) : PostDetailState()
    data class ContentLoaded(
        val post: Post,
        val author: User,
        val comments: List<Comment>
    ) : PostDetailState()
}

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val repository: TypicodeRepository,
) : ViewModel() {
    private val mutableState = MutableLiveData<PostDetailState>()

    val state: LiveData<PostDetailState>
        get() = mutableState

    private var fetchPostJob: Job? = null

    fun loadPost(postId: Int) {
        // Cancel any existing fetch job, we don't want it returning after us
        fetchPostJob?.cancel()

        // set our state to loading
        mutableState.value = PostDetailState.Loading

        // launch a coroutine to fetch the data
        fetchPostJob = viewModelScope.launch {
            try {
                val post = repository.getPostById(postId)
                val author = repository.getUserById(post.userId)
                val comments = repository.getCommentsForPost(postId)

                mutableState.postValue(
                    PostDetailState.ContentLoaded(
                        post, author, comments
                    )
                )
            } catch (e: Exception) {
                mutableState.postValue(PostDetailState.Error("Something went wrong."))
            }
        }
    }
}