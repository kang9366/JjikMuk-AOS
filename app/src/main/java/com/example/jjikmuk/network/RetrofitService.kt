package com.example.jjikmuk.network

import com.example.jjikmuk.model.InsufficientNutrientResponse
import com.example.jjikmuk.model.SignUpRequestBody
import com.example.jjikmuk.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitService{
    @POST("/api/member/singUp")
    fun signUp(
        @Body signUpRequestBody: SignUpRequestBody
    ): Call<SignUpResponse>

    @GET("/api/member/{userId}")
    fun getNutrients(
        @Path("userId") userId: Int
    ): Call<InsufficientNutrientResponse>
}