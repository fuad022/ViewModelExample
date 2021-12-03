package com.example.viewmodelexample.data.remote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelexample.data.remote.model.PostModel
import com.example.viewmodelexample.data.repo.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class PostViewModel(private val repository: Repository) : ViewModel() {
    val myCustomPosts: MutableLiveData<Response<List<PostModel>>> = MutableLiveData()

    init {
        viewModelScope.launch {
            myCustomPosts.value = repository.getCustomPosts()
        }
    }
}