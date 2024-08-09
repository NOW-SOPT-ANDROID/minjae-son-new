package com.sopt.now.compose.presentation.ui.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sopt.now.compose.presentation.ui.auth.screen.SignInRoute
import com.sopt.now.compose.presentation.ui.auth.screen.SignUpRoute
import com.sopt.now.compose.presentation.ui.home.navigation.HomeNavigator
import com.sopt.now.compose.presentation.ui.home.screen.HomeRoute

fun NavGraphBuilder.authNavGraph(
    authNavigator: AuthNavigator,
    homeNavigator: HomeNavigator
) {
    composable(
        route = "signIn/{id}/{password}/{nickname}/{phoneNumber}",
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
        SignInRoute(authNavigator, id, password, nickname, phoneNumber)
    }

    composable(route = "signUp") {
        SignUpRoute(authNavigator)
    }

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