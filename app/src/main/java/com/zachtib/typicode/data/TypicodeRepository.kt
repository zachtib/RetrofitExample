package com.zachtib.typicode.data

import com.zachtib.typicode.models.Comment
import com.zachtib.typicode.models.Post
import com.zachtib.typicode.models.User
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TypicodeRepository @Inject constructor(

){

    private val endpoint: TypicodeEndpoint

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        endpoint = retrofit.create()
    }

    suspend fun getPostsList(): List<Post> {
        return endpoint.getPostList()
    }

    suspend fun getPostById(postId: Int): Post {
        return endpoint.getPostById(postId)
    }

    suspend fun getUserById(userId: Int): User {
        return endpoint.getUser(userId)
    }

    suspend fun getCommentsForPost(postId: Int): List<Comment> {
        return endpoint.getCommentsForPost(postId)
    }
}