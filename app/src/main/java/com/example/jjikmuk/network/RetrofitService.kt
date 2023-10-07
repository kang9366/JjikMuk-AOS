package com.example.jjikmuk.network

import com.example.jjikmuk.model.InsufficientNutrientResponse
import com.example.jjikmuk.model.SignInBody
import com.example.jjikmuk.model.SignInResponse
import com.example.jjikmuk.model.SignUpRequestBody
import com.example.jjikmuk.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import com.example.jjikmuk.ui.DietResponse
import retrofit2.Response
import retrofit2.http.Query

interface RetrofitService{
    @POST("/api/member/singUp")
    fun signUp(
        @Body signUpRequestBody: SignUpRequestBody
    ): Call<SignUpResponse>

    @POST("/api/member/signIn")
    suspend fun signIn(
        @Body request : SignInBody
    ): Response<SignInResponse>

    @GET("/api/diet/{dietId}")
    suspend fun getDiet(
        @Path("dietId") dietId: Int
    ) : Response<DietResponse>


    @GET("/api/member/{userId}")
    fun getNutrients(
        @Path("userId") userId: Int
    ): Call<InsufficientNutrientResponse>
}