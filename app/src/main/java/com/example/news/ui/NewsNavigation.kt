package com.example.news.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination


object NewsDestinations{
    const val HOME_ROUTE = "home"
    const val INTERESTS_ROUTE = "interests"
}
class NewsNavigationActions(navController: NavController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(NewsDestinations.HOME_ROUTE){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToInterests: () -> Unit = {
        navController.navigate(NewsDestinations.INTERESTS_ROUTE){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}