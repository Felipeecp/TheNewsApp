package com.luiz.thenews.domain.usecase

import com.luiz.thenews.data.model.Article
import com.luiz.thenews.domain.respository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute():Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }

}