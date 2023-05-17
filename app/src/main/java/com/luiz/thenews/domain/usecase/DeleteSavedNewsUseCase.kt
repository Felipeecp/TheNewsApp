package com.luiz.thenews.domain.usecase

import com.luiz.thenews.data.model.Article
import com.luiz.thenews.domain.respository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)

}