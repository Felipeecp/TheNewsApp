package com.luiz.thenews.presentation.di

import com.luiz.thenews.presentation.adapter.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideNewsAdapter():NewsAdapter{
        return NewsAdapter()
    }

}