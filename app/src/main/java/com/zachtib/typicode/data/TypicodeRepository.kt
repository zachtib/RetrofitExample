package com.zachtib.typicode.data

import com.zachtib.typicode.models.Comment
import com.zachtib.typicode.models.Post
import com.zachtib.typicode.models.User

class TypicodeRepository {

    init {
        // Repository initialization code will go here
    }

    suspend fun getPostsList(): List<Post> {
        TODO()
    }

    suspend fun getPostById(postId: Int): Post {
        TODO()
    }

    suspend fun getUserById(userId: Int): User {
        TODO()
    }

    suspend fun getCommentsForPost(postId: Int): List<Comment> {
        TODO()
    }
}