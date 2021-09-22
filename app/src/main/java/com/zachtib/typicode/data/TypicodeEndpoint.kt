package com.zachtib.typicode.data

import com.zachtib.typicode.models.Comment
import com.zachtib.typicode.models.Post
import com.zachtib.typicode.models.User
import retrofit2.http.GET
import retrofit2.http.Path


// https://jsonplaceholder.typicode.com/    posts

interface TypicodeEndpoint {

    @GET("posts")
    suspend fun getPostList(): List<Post>

    @GET("posts/{postId}")
    suspend fun getPostById(@Path("postId") postId: Int): Post

    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): User

    @GET("posts/{postId}/comments")
    suspend fun getCommentsForPost(@Path("postId") postId: Int): List<Comment>
}