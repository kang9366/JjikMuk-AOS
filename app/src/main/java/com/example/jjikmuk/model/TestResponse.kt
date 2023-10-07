package com.example.jjikmuk.model

data class TestResponse(
    val lackList: List<Item>,
    val enoughList: List<Item>
)

data class Item(
    val name: String,
    val amount: Float,
    val diff: Float
)
