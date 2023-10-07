package com.example.jjikmuk

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = ""

private val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build()

object RetrofitBuilder{
    var api: RetrofitService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        api = retrofit.create(RetrofitService::class.java)
    }
}