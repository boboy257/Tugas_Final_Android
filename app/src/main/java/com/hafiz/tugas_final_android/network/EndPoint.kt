package com.hafiz.tugas_final_android.network

import com.hafiz.tugas_final_android.model.DataNewsItem
import retrofit2.Response
import retrofit2.http.GET

interface EndPoint {

    @GET("v2/top-headlines?country=id&apiKey=20cc7b703af1439c944bccbe9c8d46cf")
    suspend fun getLatestNews(): Response<DataNewsItem>

}