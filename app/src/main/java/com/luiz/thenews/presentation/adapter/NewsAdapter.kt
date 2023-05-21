package com.luiz.thenews.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.luiz.thenews.data.model.Article
import com.luiz.thenews.databinding.NewsListItemBinding

class NewsAdapter {


    inner class newsViewHolder(val binding: NewsListItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(article: Article){
                binding.txtTitle.text = article.title
                binding.txtDecription.text = article.description
                binding.txtPublishedAt.text = article.publishedAt
                binding.txtSource.text = article.source.name


            }
        }
}
