package com.luiz.thenews.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luiz.thenews.domain.usecase.DeleteSavedNewsUseCase
import com.luiz.thenews.domain.usecase.GetNewsHeadlinesUseCase
import com.luiz.thenews.domain.usecase.GetSavedNewsUseCase
import com.luiz.thenews.domain.usecase.GetSearchedNewsUseCase
import com.luiz.thenews.domain.usecase.SaveNewsUseCase

class NewsViewModelFactory(
    private val app:Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        ) as T
    }
}