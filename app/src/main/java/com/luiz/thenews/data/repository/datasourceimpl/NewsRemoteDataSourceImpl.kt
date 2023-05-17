package com.luiz.thenews.data.repository.datasourceimpl

import com.luiz.thenews.data.api.NewsAPIService
import com.luiz.thenews.data.model.APIResponse
import com.luiz.thenews.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country:String,
    private val page: Int
): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country,page)
    }
}