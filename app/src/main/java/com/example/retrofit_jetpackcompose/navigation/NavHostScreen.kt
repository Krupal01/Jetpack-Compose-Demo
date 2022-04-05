package com.example.retrofit_jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retrofit_jetpackcompose.ui.screen.NetworkScr
import com.example.retrofit_jetpackcompose.ui.screen.DatabaseScr
import com.example.retrofit_jetpackcompose.utils.NavigationRoute
import com.example.retrofit_jetpackcompose.viewModel.MainViewModel

@Composable
fun NavHostScreen(viewModel: MainViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationRoute.NETWORK_SCR_ROUTE ){
        composable(route = NavigationRoute.NETWORK_SCR_ROUTE){ NetworkScr(viewModel = viewModel , navController = navController) }
        composable(route = NavigationRoute.DATABASE_SCR_ROUTE){ DatabaseScr(viewModel = viewModel , navController = navController)}
    }
}