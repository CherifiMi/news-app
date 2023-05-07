package com.example.news.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.news.data.AppContainer
import com.example.news.theme.NewsTheme


@Composable
fun NewsApp(
    appContainer: AppContainer,
    widthSizeClass: WindowWidthSizeClass
) {
    NewsTheme() {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            NewsNavigationActions(navController)
        }
        val coroutineScope = rememberCoroutineScope()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route ?: NewsDestinations.HOME_ROUTE
        val isExpandedScreen = widthSizeClass == WindowWidthSizeClass.Expanded
        val sizeAwareDrawerState = rememberSizeAwareDrawerState(isExpandedScreen)

        ModelNaviagtionDrawer(
            drawerContent = {
                AppDrawer(
                    currentRoute = currentRoute,
                    navigateToHome = navigationActions.navigateToHome
                )
            }
        ){

        }
    }
}