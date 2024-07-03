package com.example.retrofitapi

import com.example.retrofitapi.Moden.NewModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("everything?q=tesla&from=2024-06-03&sortBy=publishedAt&apiKey=c3c66065028b4035905006bbbcfa1c24")

    fun getNews(): Call<NewModel>

}