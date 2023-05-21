package com.luiz.thenews.data.repository.datasource

import com.luiz.thenews.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse>

}