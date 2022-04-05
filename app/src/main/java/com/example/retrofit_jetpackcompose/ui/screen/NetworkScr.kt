package com.example.retrofit_jetpackcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.retrofit_jetpackcompose.R
import com.example.retrofit_jetpackcompose.model.Post
import com.example.retrofit_jetpackcompose.utils.NavigationRoute
import com.example.retrofit_jetpackcompose.utils.ServiceState
import com.example.retrofit_jetpackcompose.viewModel.MainViewModel

@Composable
fun NetworkScr(viewModel: MainViewModel , navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Network Data")},
                actions = {
                    IconButton(
                        onClick = { navController.navigate(NavigationRoute.DATABASE_SCR_ROUTE) }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_save_24), contentDescription = "Saved" )
                    }
                }
            )
        }
    ) {
        GetData(mainViewModel = viewModel)
    }
}

@Composable
fun RowItem(post: Post, viewModel : MainViewModel){
    val isAdded = remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column() {
            Text(text = post.body!!, modifier = Modifier.padding(10.dp), fontStyle = FontStyle.Italic)
            Button(onClick = {
                if (isAdded.value) {
                    viewModel.deletePost(post)
                }else{
                    viewModel.insertPost(post)
                }
                isAdded.value = !isAdded.value

            }) {
                Icon(painter = if (isAdded.value) painterResource(id = R.drawable.ic_baseline_turned_in_24)
                else painterResource(id = R.drawable.ic_baseline_turned_in_not_24), contentDescription = "save" )
            }
        }
    }
}
//ic_baseline_turned_in_24
@Composable
fun GetData(mainViewModel: MainViewModel){
    when(val result = mainViewModel.response.value){
        is ServiceState.Sucess -> {
            LazyColumn{
                items(result.posts){post ->
                    RowItem(post = post , viewModel = mainViewModel)
                }
            }
        }
        is ServiceState.Failure -> {
            Text(text = "${result.msg}")
        }
        ServiceState.Loading->{
            CircularProgressIndicator()
        }
        ServiceState.Empty -> {

        }
    }
}