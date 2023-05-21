package com.luiz.thenews.data.repository.datasourceimpl

import com.luiz.thenews.data.api.NewsAPIService
import com.luiz.thenews.data.model.APIResponse
import com.luiz.thenews.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country,page)
    }
}