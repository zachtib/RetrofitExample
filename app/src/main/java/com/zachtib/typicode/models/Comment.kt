package com.zachtib.typicode.models

import com.squareup.moshi.JsonClass


//{
//    "postId": 1,
//    "id": 1,
//    "name": "id labore ex et quam laborum",
//    "email": "Eliseo@gardner.biz",
//    "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
//},

@JsonClass(generateAdapter = true)
data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
)