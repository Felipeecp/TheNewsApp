package com.luiz.thenews.presentation.di

import com.luiz.thenews.data.repository.NewsRepositoryImpl
import com.luiz.thenews.data.repository.datasource.NewsRemoteDataSource
import com.luiz.thenews.domain.respository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providerNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource
    ):NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource)
    }

}