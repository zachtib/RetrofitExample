package com.zachtib.typicode.data

import com.zachtib.typicode.models.Comment
import com.zachtib.typicode.models.Post
import com.zachtib.typicode.models.User
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TypicodeRepository @Inject constructor(

){

    init {
        // Repository initialization code will go here
    }

    private val examplePosts = listOf(
        Post(1, 1, "First Post", "Lorem Ipsum"),
        Post(1, 2, "Second Post", "Lorem Ipsum"),
        Post(1, 3, "Third Post", "Lorem Ipsum"),
        Post(1, 4, "Fourth Post", "Lorem Ipsum"),
        Post(1, 5, "Fifth Post", "Lorem Ipsum"),
        Post(1, 6, "Sixth Post", "Lorem Ipsum"),
        Post(1, 7, "Seventh Post", "Lorem Ipsum"),
    )

    suspend fun getPostsList(): List<Post> {
        delay(500)

        return examplePosts
    }

    suspend fun getPostById(postId: Int): Post {
        delay(100)

        return examplePosts.first { it.id == postId }
    }

    suspend fun getUserById(userId: Int): User {
        delay(100)

        return User(userId, "Sample User", "sampleuser", "sample@example.com")
    }

    suspend fun getCommentsForPost(postId: Int): List<Comment> {
        delay(100)

        return listOf(
            Comment(postId, 1, "First!", "user@user.org", "Lorem Ipsum Dolor Sit Amet"),
            Comment(postId, 2, "Second!", "user@user.org", "Lorem Ipsum Dolor Sit Amet"),
            Comment(postId, 3, "Third!", "user@user.org", "Lorem Ipsum Dolor Sit Amet"),
            Comment(postId, 4, "Ummm!", "user@user.org", "Lorem Ipsum Dolor Sit Amet"),
            Comment(postId, 5, "More!", "user@user.org", "Lorem Ipsum Dolor Sit Amet"),
            Comment(postId, 6, "Canned!", "user@user.org", "Lorem Ipsum Dolor Sit Amet"),
            Comment(postId, 7, "Data!", "user@user.org", "Lorem Ipsum Dolor Sit Amet"),
            Comment(postId, 8, "Goes!", "user@user.org", "Lorem Ipsum Dolor Sit Amet"),
            Comment(postId, 9, "Here!", "user@user.org", "Lorem Ipsum Dolor Sit Amet"),
        )
    }
}