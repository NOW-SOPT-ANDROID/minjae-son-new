package com.sopt.now.compose.presentation.ui.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sopt.now.compose.presentation.ui.home.screen.HomeRoute

fun NavGraphBuilder.homeNavGraph(homeNavigator: HomeNavigator) {

    composable(
        route = "home/{id}/{password}/{nickname}/{phoneNumber}",
        arguments = listOf(
            navArgument("id") { type = NavType.StringType },
            navArgument("password") { type = NavType.StringType },
            navArgument("nickname") { type = NavType.StringType },
            navArgument("phoneNumber") { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id") ?: ""
        val password = backStackEntry.arguments?.getString("password") ?: ""
        val nickname = backStackEntry.arguments?.getString("nickname") ?: ""
        val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
        HomeRoute(homeNavigator, id, password, nickname, phoneNumber)
    }
}