package com.sopt.now.compose.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.now.compose.presentation.home.screen.HomeRoute

fun NavGraphBuilder.homeNavGraph(
    homeNavigator: HomeNavigator
) {
    composable("home") {
        HomeRoute(homeNavigator)
    }
}