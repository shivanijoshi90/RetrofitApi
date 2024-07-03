package com.example.retrofitapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapi.Moden.ArticlesItem
import com.example.retrofitapi.Moden.NewModel
import com.example.retrofitapi.databinding.ActivityMainBinding

import com.example.retrofittapicalling.Adapter.RetrofitAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newsAPICalling()

    }
    fun rvdata(newsModel: List<ArticlesItem?>) {
        val adapter = RetrofitAdapter(newsModel)
        binding.RvAPIData.adapter = adapter

    }
    fun newsAPICalling() {
        var apiInterface = ApiClient.getClient()?.create(ApiInterface::class.java)

        apiInterface?.getNews()?.enqueue(object : Callback<NewModel> {
            override fun onResponse(call: Call<NewModel>, response: Response<NewModel>) {
                var modaClass = response.body()
                Log.i("TAG", "onResponse: ${modaClass!!.articles!!.get(0)!!.title}")

                rvdata(modaClass.articles!!)
            }

            override fun onFailure(call: Call<NewModel>, t: Throwable) {
                Log.e("Error", "onFailure: ${t.message}")
            }
        })
    }
}


