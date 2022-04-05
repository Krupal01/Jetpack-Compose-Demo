package com.example.retrofit_jetpackcompose.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retrofit_jetpackcompose.model.Post

@Database(entities = [Post::class], version = 1)
abstract class PostDatabase : RoomDatabase() {

    abstract fun getPostDao() : PostDao
}