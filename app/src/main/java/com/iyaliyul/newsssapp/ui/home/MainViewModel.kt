package com.iyaliyul.newsssapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iyaliyul.newsssapp.data.model.ResponseNews
import com.iyaliyul.newsssapp.data.repository.NewsRepository
import com.iyaliyul.newsssapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
//menginjek repository
class MainViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel() {

    //2 variable,
    //1 transaksi di dalam view model,
    //yang lainnya di dalam (activity/fragment lain)
    private val _newsData = MutableLiveData<Resource<ResponseNews>>()
    val newsData = _newsData

    init {
        fetchNewsViewModel()
    }

    //nge fecth data
    //ngejalanin coroutine flownya di dalam view model scope
    //viewmodelscope = tempat dimana coroutine ini bakal berjalan.
    private fun fetchNewsViewModel() = viewModelScope.launch {
        _newsData.value = Resource.Loading
        
        repository.fetchNewsRepository().collect { news ->
            _newsData.value = news
        }
    }

}