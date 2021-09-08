package com.zachtib.typicode.models

data class Post(
    val id: Int,
    val title: String,
    val body: String = ""
)