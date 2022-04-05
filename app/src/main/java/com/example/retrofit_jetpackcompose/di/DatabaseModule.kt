package com.example.retrofit_jetpackcompose.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofit_jetpackcompose.db.PostDao
import com.example.retrofit_jetpackcompose.db.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun getDbInstance(@ApplicationContext context: Context) : PostDatabase{
        return Room.databaseBuilder(context,PostDatabase::class.java,"Post Database").build()
    }

    @Provides
    @Singleton
    fun getPostDao(db : PostDatabase) : PostDao{
        return db.getPostDao()
    }

}