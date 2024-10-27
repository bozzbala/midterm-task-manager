package com.example.assignment2.models

data class Post(
    val username: String,
    val profileImageRes: Int, // Ресурс изображения профиля
    val postImageRes: Int,    // Ресурс изображения поста
    val caption: String,      // Подпись к посту
    val likesCount: Int       // Количество лайков
)