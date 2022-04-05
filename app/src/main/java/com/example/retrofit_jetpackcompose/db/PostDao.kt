package com.example.retrofit_jetpackcompose.db

import androidx.room.*
import com.example.retrofit_jetpackcompose.model.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: Post)

    @Query("select * from Post")
    fun getAllPost() : List<Post>

    @Delete
    suspend fun deletePost(post: Post)
}