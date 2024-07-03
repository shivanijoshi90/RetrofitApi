package com.example.retrofittapicalling.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapi.Moden.ArticlesItem
import com.example.retrofitapi.R
import com.example.retrofitapi.databinding.RetrofitItemBinding


class RetrofitAdapter(val newsModel: List<ArticlesItem?>) :
    RecyclerView.Adapter<RetrofitAdapter.RetrofitViewHolder>() {

    class RetrofitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var binding = RetrofitItemBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.retrofit_item, parent, false)
        return RetrofitViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsModel.size
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {

        holder.binding.titlenews.setText("${newsModel.get(position)?.title}")
        holder.binding.descnews.setText("${newsModel.get(position)?.description}")
        holder.binding.contentnews.setText("${newsModel.get(position)?.content}")
        holder.binding.urlnews.setText("${newsModel.get(position)?.url}")
        holder.binding.authornews.setText("${newsModel.get(position)?.author}")
      //  holder.binding.datenews.setText("${newsModel.get(position)?.publishedAt}")
        Glide.with(holder.itemView).load(newsModel.get(position)?.urlToImage).into(holder.binding.imgnews)

    }
}