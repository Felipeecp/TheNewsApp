package com.luiz.thenews.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luiz.thenews.data.model.APIResponse
import com.luiz.thenews.data.util.Resource
import com.luiz.thenews.domain.usecase.GetNewsHeadlinesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(
    val app:Application,
    val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
):AndroidViewModel(app) {

    val newsHeadline: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLines(country:String, page:Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if(isNetWorkAvailable(app)){
                newsHeadline.postValue(Resource.Loading())
                val apiResult = getNewsHeadlinesUseCase.execute(country,page)
                newsHeadline.postValue(apiResult)
            }else{
                newsHeadline.postValue(Resource.Error("Internet is not available"))
            }
        }catch (e:Exception){
            newsHeadline.postValue(Resource.Error(e.message.toString()))
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

}