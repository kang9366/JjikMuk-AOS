package com.example.jjikmuk.model

data class SignUpRequestBody(
    val email: String,
    val nickName: String,
    val age: Int,
    val fcmToken: String
)
