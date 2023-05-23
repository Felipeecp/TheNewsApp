package com.luiz.thenews.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luiz.thenews.data.model.Article
import com.luiz.thenews.databinding.NewsListItemBinding

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }


    inner class NewsViewHolder(val binding: NewsListItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(article: Article){
                binding.txtTitle.text = article.title
                binding.txtDescription.text = article.description
                binding.txtPublishedAt.text = article.publishedAt
                binding.txtSource.text = article.source?.name

                Glide.with(binding.imgArticle.context)
                    .load(article.urlToImage)
                    .into(binding.imgArticle)

                binding.root.setOnClickListener {
                    onItemClickListener?.let {
                        it(article)
                    }
                }
            }
        }

    private var onItemClickListener: ((Article)->Unit)?=null

    fun setOnItemClickListener(listener: (Article)->Unit){
        onItemClickListener = listener
    }


}
