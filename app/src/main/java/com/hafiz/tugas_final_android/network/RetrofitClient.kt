package com.hafiz.tugas_final_android.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val Base_URL = "https://newsapi.org/"

    val instance : EndPoint by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(EndPoint::class.java)
    }

}