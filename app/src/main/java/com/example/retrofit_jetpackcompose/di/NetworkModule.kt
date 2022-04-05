package com.example.retrofit_jetpackcompose.di

import com.example.retrofit_jetpackcompose.network.PostService
import com.example.retrofit_jetpackcompose.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun getRetroInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getPostService(retrofit: Retrofit) : PostService{
        return retrofit.create(PostService::class.java)
    }
}