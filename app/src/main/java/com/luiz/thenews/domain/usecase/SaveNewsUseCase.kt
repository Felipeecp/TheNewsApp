package com.luiz.thenews.domain.usecase

import com.luiz.thenews.data.model.Article
import com.luiz.thenews.domain.respository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article)=newsRepository.saveNews(article)

}