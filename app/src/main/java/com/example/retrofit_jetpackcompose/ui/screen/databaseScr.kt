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
import com.example.retrofit_jetpackcompose.viewModel.MainViewModel

@Composable
fun DatabaseScr(viewModel: MainViewModel , navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Saved Data")},
                actions = {
                    IconButton(
                        onClick = { navController.navigate(NavigationRoute.NETWORK_SCR_ROUTE) }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_cloud_24), contentDescription = "Cloud" )
                    }
                }
            )
        }
    ){
        getSavedData(viewModel = viewModel)
    }
}

@Composable
fun getSavedData(viewModel: MainViewModel){
    viewModel.getSavedPost()
    LazyColumn{
        items(viewModel.dbResponce.value){
           post -> SavedRowItem(post = post )
        }
    }
}

@Composable
fun SavedRowItem(post: Post){
    Card(modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column() {
            Text(text = post.body!!, modifier = Modifier.padding(10.dp), fontStyle = FontStyle.Italic)
        }
    }
}
