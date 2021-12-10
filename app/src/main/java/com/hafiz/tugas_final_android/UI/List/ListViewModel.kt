package com.hafiz.tugas_final_android.UI.List

import android.util.Log
import androidx.lifecycle.ViewModel
import com.hafiz.tugas_final_android.model.Article
import com.hafiz.tugas_final_android.model.DataNewsItem
import com.hafiz.tugas_final_android.network.RetrofitClient
import retrofit2.Response
import java.lang.Exception

class ListViewModel: ViewModel() {
    private var TAG = "ListViewModel"

    private var listNews = mutableListOf<Article>()

    suspend fun getLatesNews() {
        var response: Response<DataNewsItem>? = null
        try {
            response = RetrofitClient.instance.getLatestNews()
            if(response.isSuccessful) {
                listNews.addAll(response.body()?.articles as MutableList<Article>)
            }
        } catch (e: Exception) {
            Log.e(TAG, "${e.message}")
        }
    }

}