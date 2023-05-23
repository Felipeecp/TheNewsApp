package com.luiz.thenews.domain.respository

import androidx.lifecycle.LiveData
import com.luiz.thenews.data.model.APIResponse
import com.luiz.thenews.data.model.Article
import com.luiz.thenews.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>

    suspend fun getSearchedNews(country: String,searchQuery:String,page: Int):Resource<APIResponse>

    suspend fun saveNews(article: Article)

    suspend fun deleteNews(article: Article)

    fun getSavedNews(): Flow<List<Article>>



}