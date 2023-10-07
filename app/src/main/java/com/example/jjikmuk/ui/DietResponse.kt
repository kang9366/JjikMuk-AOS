package com.example.jjikmuk.ui

data class DietResponse(
    val enoughList: List<Enough> = listOf(),
    val lackList: List<Lack> = listOf()
)

data class Enough(
    val amount: Double = 0.0,
    val diff: Double = 0.0,
    val name: String = ""
)

data class Lack(
    val amount: Double = 0.0,
    val diff: Double = 0.0,
    val name: String = ""
)
