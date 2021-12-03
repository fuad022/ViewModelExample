package com.example.viewmodelexample.data.remote.api

import com.example.viewmodelexample.data.remote.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts")
    suspend fun getCustomPosts(): Response<List<PostModel>>
}
