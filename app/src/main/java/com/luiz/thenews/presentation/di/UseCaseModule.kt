package com.luiz.thenews.presentation.di

import com.luiz.thenews.domain.respository.NewsRepository
import com.luiz.thenews.domain.usecase.DeleteSavedNewsUseCase
import com.luiz.thenews.domain.usecase.GetNewsHeadlinesUseCase
import com.luiz.thenews.domain.usecase.GetSavedNewsUseCase
import com.luiz.thenews.domain.usecase.GetSearchedNewsUseCase
import com.luiz.thenews.domain.usecase.SaveNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideNewsHeadLinesUseCase(
        newsRepository: NewsRepository
    ):GetNewsHeadlinesUseCase{
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideSearchedNewsUseCase(
        newsRepository: NewsRepository
    ):GetSearchedNewsUseCase{
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideSaveNewsUseCase(
        newsRepository: NewsRepository
    ):SaveNewsUseCase{
        return SaveNewsUseCase(newsRepository)
    }
    @Provides
    @Singleton
    fun provideGetSavedNewsUseCase(
        newsRepository: NewsRepository
    ):GetSavedNewsUseCase{
        return GetSavedNewsUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteSavedNewsUseCase(
        newsRepository: NewsRepository
    ):DeleteSavedNewsUseCase{
        return DeleteSavedNewsUseCase(newsRepository)
    }

}