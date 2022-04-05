package com.example.retrofit_jetpackcompose.network

import com.example.retrofit_jetpackcompose.model.Post
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun getPosts() : List<Post>
}