package com.zachtib.typicode.models

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)