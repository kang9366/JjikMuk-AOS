package com.example.jjikmuk.network

import com.example.jjikmuk.ui.DietResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService{

    @GET("/api/diet/{dietId}")
    suspend fun getDiet(
        @Path("dietId") dietId: Int
    ) : Response<DietResponse>


}