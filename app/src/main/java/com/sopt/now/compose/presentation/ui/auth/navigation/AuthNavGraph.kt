package com.sopt.now.compose.presentation.ui.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sopt.now.compose.presentation.ui.auth.screen.AuthViewModel
import com.sopt.now.compose.presentation.ui.auth.screen.SignInRoute
import com.sopt.now.compose.presentation.ui.auth.screen.SignUpRoute

fun NavGraphBuilder.authNavGraph(
    authNavigator: AuthNavigator,
    authViewModel: AuthViewModel
) {
    composable(route = "signIn") {
        SignInRoute(
            authNavigator = authNavigator,
            authViewModel = authViewModel
        )
    }

    composable(route = "signUp") {
        SignUpRoute(
            authNavigator = authNavigator,
            authViewModel = authViewModel
        )
    }
}