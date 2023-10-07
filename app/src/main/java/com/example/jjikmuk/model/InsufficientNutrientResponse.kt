package com.example.jjikmuk.model

data class InsufficientNutrientResponse(
    val nutrientInfoList: List<NutrientInfo>,
    val goodDietName: String
)

data class NutrientInfo(
    val name: String,
    val amount: Float,
    val diff: Float
)