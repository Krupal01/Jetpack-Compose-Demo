package com.example.retrofit_jetpackcompose.repository

import com.example.retrofit_jetpackcompose.db.PostDao
import com.example.retrofit_jetpackcompose.model.Post
import com.example.retrofit_jetpackcompose.network.PostService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject
constructor(
    private val service: PostService ,
    private val postDao : PostDao
) {

    fun getPost():Flow<List<Post>> = flow {
        emit(service.getPosts())
    }.flowOn(Dispatchers.IO)

    suspend fun insertPost(post: Post){
        postDao.insertPost(post)
    }

    suspend fun deletePost(post: Post){
        postDao.deletePost(post)
    }

    fun getSavedPost():Flow<List<Post>> = flow {
        emit(postDao.getAllPost())
    }.flowOn(Dispatchers.IO)

}