package com.example.news.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.news.data.AppContainer
import com.example.news.ui.home.HomeRoute
import com.example.news.ui.home.HomeViewModel
import com.example.news.ui.intersets.InterestsRoute
import com.example.news.ui.intersets.InterestsViewModel


@Composable
fun NewsNavGraph(
    appCOntainer: AppContainer,
    isExpandedScreen: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    openDrawer: () -> Unit = {},
    startingDestination: String = NewsDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startingDestination,
        modifier = modifier
    ) {
        composable(NewsDestinations.HOME_ROUTE) {
            var homeViewModel: HomeViewModel =
                viewModel(
                    factory = HomeViewModel.provideFactory(appContainer.postReposetory)
                )
            HomeRoute(
                homeViewModel = homeViewModel,
                isExpandedScreen = isExpandedScreen,
                openDrawer = openDrawer
            )
        }

        composable(NewsDestinations.INTERESTS_ROUTE) {
            val interestsViewModel: InterestsViewModel =
                viewModel(
                    factory = InterestsViewModel.provideFactory(appContainer.interestsRepository)
                )
            InterestsRoute(
                interestsViewModel = interestsViewModel,
                isExpandedScreen = isExpandedScreen,
                openDrawer = openDrawer
            )
        }
    }
}




