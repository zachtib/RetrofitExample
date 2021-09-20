package com.zachtib.typicode.ui.postdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zachtib.typicode.data.TypicodeRepository
import com.zachtib.typicode.models.Comment
import com.zachtib.typicode.models.Post
import com.zachtib.typicode.models.User
import com.zachtib.typicode.util.PostId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
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
    @PostId private val postId: Int,
) : ViewModel() {
    private val mutableState = MutableLiveData<PostDetailState>()

    val state: LiveData<PostDetailState>
        get() = mutableState

    init {
        Timber.d("Fetching post with id $postId")
        viewModelScope.launch {
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