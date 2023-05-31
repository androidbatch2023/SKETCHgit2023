package com.example.a15_5_23_apiwithcoruting

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitProvider {
    /*private const val BASE_URL2 = "https://api.github.com/"
    private const val end_point = "users"
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"*/
    private var retrofit: Retrofit? = null

    fun getInstance(BASE_URL:String): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}