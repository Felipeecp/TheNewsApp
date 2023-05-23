package com.luiz.thenews.presentation.di

import android.app.Application
import com.luiz.thenews.domain.respository.NewsRepository
import com.luiz.thenews.domain.usecase.DeleteSavedNewsUseCase
import com.luiz.thenews.domain.usecase.GetNewsHeadlinesUseCase
import com.luiz.thenews.domain.usecase.GetSavedNewsUseCase
import com.luiz.thenews.domain.usecase.GetSearchedNewsUseCase
import com.luiz.thenews.domain.usecase.SaveNewsUseCase
import com.luiz.thenews.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase,
        deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ):NewsViewModelFactory{
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        )
    }

}