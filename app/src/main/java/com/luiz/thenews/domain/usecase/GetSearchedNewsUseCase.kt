package com.luiz.thenews.domain.usecase

import com.luiz.thenews.data.model.APIResponse
import com.luiz.thenews.data.util.Resource
import com.luiz.thenews.domain.respository.NewsRepository

class GetSearchedNewsUseCase(private val  newsRepository: NewsRepository) {

    suspend fun execute(searchQuery:String):Resource<APIResponse>{
        return newsRepository.getSearchedNews(searchQuery)
    }

}