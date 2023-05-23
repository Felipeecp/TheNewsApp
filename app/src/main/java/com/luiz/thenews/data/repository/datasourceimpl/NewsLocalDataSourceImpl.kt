package com.luiz.thenews.data.repository.datasourceimpl

import com.luiz.thenews.data.db.ArticleDao
import com.luiz.thenews.data.model.Article
import com.luiz.thenews.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
):NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        articleDao.deleteArticle(article)
    }


}