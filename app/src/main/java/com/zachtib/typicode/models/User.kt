package com.zachtib.typicode.models

import com.squareup.moshi.JsonClass


//"id": 1,
//"name": "Leanne Graham",
//"username": "Bret",
//"email": "Sincere@april.biz",


@JsonClass(generateAdapter = true)
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
)