package com.example.retrofit_jetpackcompose.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_jetpackcompose.model.Post
import com.example.retrofit_jetpackcompose.repository.PostRepository
import com.example.retrofit_jetpackcompose.utils.ServiceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    val response : MutableState<ServiceState> = mutableStateOf(ServiceState.Empty)
    val dbResponce : MutableState<List<Post>> = mutableStateOf(listOf())

    init {
        getResponse()
        getSavedPost()
    }

    fun getResponse() = viewModelScope.launch{
        postRepository.getPost()
            .onStart {
                response.value = ServiceState.Loading
            }
            .catch {
                response.value = ServiceState.Failure(it)
            }
            .collect{
                response.value = ServiceState.Sucess(it)
            }
    }

    fun insertPost(post: Post) = viewModelScope.launch {
        postRepository.insertPost(post)
    }

    fun deletePost(post : Post) = viewModelScope.launch {
        postRepository.deletePost(post)
    }

    fun getSavedPost() = viewModelScope.launch{
        postRepository.getSavedPost().collect{
            dbResponce.value = it
        }
    }


}