package com.zachtib.typicode.ui.postdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zachtib.typicode.models.Comment
import com.zachtib.typicode.models.Post
import com.zachtib.typicode.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
class PostDetailViewModel @Inject constructor() : ViewModel() {
    private val mutableState = MutableLiveData<PostDetailState>()

    val state: LiveData<PostDetailState>
        get() = mutableState

    private var fetchPostJob: Job? = null

    fun loadPost(postId: Int) {
        fetchPostJob?.cancel()
        fetchPostJob = viewModelScope.launch {
            mutableState.postValue(PostDetailState.Loading)
            delay(2000)
            mutableState.postValue(PostDetailState.ContentLoaded(
                post = Post(1, "Hello, World", """
                    This is some text that is long, and I will type a bunch of text.
                    
                    Also newlines, I guess.
                """.trimIndent()),
                author = User("foobar"),
                comments = listOf(
                    Comment("newuser", "user@example.com", "First!"),
                    Comment("otheruser", "user@example.com", "Second!"),
                    Comment("myuser", "user@example.com", "^ this"),
                    Comment("newuser", "user@example.com", "First!"),
                    Comment("otheruser", "user@example.com", "Second!"),
                    Comment("myuser", "user@example.com", "^ this"),
                    Comment("newuser", "user@example.com", "First!"),
                    Comment("otheruser", "user@example.com", "Second!"),
                    Comment("myuser", "user@example.com", "^ this"),
                    Comment("newuser", "user@example.com", "First!"),
                    Comment("otheruser", "user@example.com", "Second!"),
                    Comment("myuser", "user@example.com", "^ this"),
                )
            ))
        }
    }
}