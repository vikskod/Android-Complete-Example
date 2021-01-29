package com.vikskod.retrofitexaxmple.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.RvNewsItemBinding
import com.squareup.picasso.Picasso
import com.vikskod.retrofitexaxmple.model.News


/**
 * Created by Vikash Parajuli on 29/01/2021.
 * vparajuli819@gmail.com
 */
class MyAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    private var articleList = ArrayList<News.Article>()

    fun setList(news: News) {
        articleList.clear()
        articleList.addAll(news.articles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RvNewsItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.rv_news_item, parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}

class MyViewHolder(val binding: RvNewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: News.Article) {
        binding.tvTitle.text = data.title

        Picasso.get().load(data.urlToImage).into(binding.imageView)
    }
}