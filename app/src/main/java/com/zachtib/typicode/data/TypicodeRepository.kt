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

    suspend fun getPostsList(): List<Post> {
        delay(500)

        return listOf(
            Post(1, "Hello, World"),
            Post(2, "Hello, Android"),
            Post(3, "Hello, Internet"),
        )
    }

    suspend fun getPostById(postId: Int): Post {
        delay(100)

        return Post(
            1,
            "Hello, World",
            """
                This is some text that is long, and I will type a bunch of text.
                
                This is just a bunch of garbage words that I'm typing in so that this app can have some canned data to display, and this is a long line so that it will wrap text, I guess.
                
                Also newlines, I guess.
            """.trimIndent()
        )
    }

    suspend fun getUserById(userId: Int): User {
        delay(100)

        return User("superuser")
    }

    suspend fun getCommentsForPost(postId: Int): List<Comment> {
        delay(100)

        return listOf(
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
    }
}