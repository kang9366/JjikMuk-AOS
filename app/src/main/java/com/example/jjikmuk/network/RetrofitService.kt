package com.example.jjikmuk.network

import com.example.jjikmuk.model.ImageResponse
import com.example.jjikmuk.model.InsufficientNutrientResponse
import com.example.jjikmuk.model.SignUpRequestBody
import com.example.jjikmuk.model.SignUpResponse
import com.example.jjikmuk.model.TestResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

import com.example.jjikmuk.ui.DietResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.Part
import retrofit2.http.Path

interface RetrofitService{
    @POST("/api/member/singUp")
    fun signUp(
        @Body signUpRequestBody: SignUpRequestBody
    ): Call<SignUpResponse>

    @GET("/api/diet/{dietId}")
    fun getDiet(
        @Path("dietId") dietId: Int
    ) : Call<TestResponse>


    @GET("/api/member/{userId}")
    fun getNutrients(
        @Path("userId") userId: Int
    ): Call<InsufficientNutrientResponse>

    @Multipart
    @POST("/api/diet/{userId}")
    fun postImage(
        @Path("userId") userId: Int,
        @Part image: MultipartBody.Part
    ): Call<ImageResponse>
}