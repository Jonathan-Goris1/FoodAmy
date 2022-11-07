package com.zybooks.foodamy.domain.model

data class Comment(
    val difference: String = "",
    val id: Int = -1,
    val text: String = "",
    val user: User = User()
)
