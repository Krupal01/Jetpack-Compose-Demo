package com.example.retrofit_jetpackcompose.utils

import com.example.retrofit_jetpackcompose.model.Post

sealed class ServiceState{

    class Sucess(val posts : List<Post>) : ServiceState()
    class Failure(val msg : Throwable) : ServiceState()
    object Loading : ServiceState()
    object Empty : ServiceState()
}
