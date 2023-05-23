package com.luiz.thenews.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.luiz.thenews.data.model.APIResponse
import com.luiz.thenews.data.model.Article
import com.luiz.thenews.data.util.Resource
import com.luiz.thenews.domain.usecase.DeleteSavedNewsUseCase
import com.luiz.thenews.domain.usecase.GetNewsHeadlinesUseCase
import com.luiz.thenews.domain.usecase.GetSavedNewsUseCase
import com.luiz.thenews.domain.usecase.GetSearchedNewsUseCase
import com.luiz.thenews.domain.usecase.SaveNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(
    val app:Application,
    val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
):AndroidViewModel(app) {

    val newsHeadLines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLines(country:String, page:Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if(isNetWorkAvailable(app)){
                newsHeadLines.postValue(Resource.Loading())
                val apiResult = getNewsHeadlinesUseCase.execute(country,page)
                newsHeadLines.postValue(apiResult)
            }else{
                newsHeadLines.postValue(Resource.Error("Internet is not available"))
            }
        }catch (e:Exception){
            newsHeadLines.postValue(Resource.Error(e.message.toString()))
        }

    }

    private fun isNetWorkAvailable(context:Context?):Boolean{
        if(context==null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if(capabilities!=null){
            when{
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)->{
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)->{
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)->{
                    return true
                }
            }
        }else{
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if(activeNetworkInfo!=null && activeNetworkInfo.isConnected){
                return true
            }
        }
        return false
    }

    //search
    val searchedNews: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun searchNews(
        country: String,
        searchQuery:String,
        page: Int
    ) = viewModelScope.launch {
        searchedNews.postValue(Resource.Loading())
        try {
            if(isNetWorkAvailable(app)){
                val response = getSearchedNewsUseCase.execute(
                    country,
                    searchQuery,
                    page
                )
                searchedNews.postValue(response)
            }else{
                searchedNews.postValue(Resource.Error("No internet connection"))
            }
        }catch (e:Exception){
            searchedNews.postValue(Resource.Error(e.message.toString()))
        }

    }

    //local data
    fun saveArticle(article: Article)=viewModelScope.launch {
        saveNewsUseCase.execute(article)
    }

    fun getSavedNews () = liveData {
        getSavedNewsUseCase.execute().collect{
            emit(it)
        }
    }

    fun deleteArticle(article: Article)= viewModelScope.launch {
        deleteSavedNewsUseCase.execute(article)
    }

}