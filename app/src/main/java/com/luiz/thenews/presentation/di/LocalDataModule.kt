package com.luiz.thenews.presentation.di

import com.luiz.thenews.data.db.ArticleDao
import com.luiz.thenews.data.repository.datasource.NewsLocalDataSource
import com.luiz.thenews.data.repository.datasourceimpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(articleDao: ArticleDao):NewsLocalDataSource{
        return NewsLocalDataSourceImpl(articleDao)
    }

}