package com.sopt.now.compose.presentation.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.now.compose.presentation.auth.screen.SignInRoute
import com.sopt.now.compose.presentation.auth.screen.SignUpRoute
import com.sopt.now.compose.presentation.home.navigation.HomeNavigator
import com.sopt.now.compose.presentation.home.screen.HomeRoute

fun NavGraphBuilder.authNavGraph(
    authNavigator: AuthNavigator,
    homeNavigator: HomeNavigator
) {
    composable("signIn") {
        SignInRoute(authNavigator)
    }
    composable("signUp") {
        SignUpRoute(authNavigator)
    }
    composable("home") {
        HomeRoute(homeNavigator)
    }
}