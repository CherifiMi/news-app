package com.example.news.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.news.data.AppContainer


@Composable
fun NewsNavGraph(
    appCOntainer: AppContainer,
    isExpandedScreen: Boolean,
    navController: NavHostController = rememberNavController(),
    openDrawer: () -> Unit = {},
    startingDestination : String = NewsDestinations.HOME_ROUTE
) {

}