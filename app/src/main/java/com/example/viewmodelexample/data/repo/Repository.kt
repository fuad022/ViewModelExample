package com.example.viewmodelexample.data.repo

import com.example.viewmodelexample.data.remote.api.RetrofitInstance
import com.example.viewmodelexample.data.remote.model.PostModel
import retrofit2.Response

class Repository {
    suspend fun getCustomPosts(): Response<List<PostModel>> =
        RetrofitInstance.api.getCustomPosts()
}
