package com.luiz.thenews.data.repository.datasource

import com.luiz.thenews.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)

    fun getSavedArticles(): Flow<List<Article>>

    suspend fun deleteArticlesFromDB(article: Article)

}