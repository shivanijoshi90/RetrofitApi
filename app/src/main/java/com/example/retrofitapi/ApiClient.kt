package com.example.retrofitapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {


    companion object {
        val BASE_URL = "https://newsapi.org/v2/"

        var retrofit: Retrofit? = null
        fun getClient(): Retrofit? {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }

    }
}