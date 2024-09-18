package com.sopt.now.compose.presentation.ui.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sopt.now.compose.presentation.ui.auth.navigation.AuthNavigator
import com.sopt.now.compose.presentation.ui.auth.navigation.authNavGraph
import com.sopt.now.compose.presentation.ui.home.navigation.HomeNavigator
import com.sopt.now.compose.presentation.ui.home.navigation.homeNavGraph

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    authNavigator: AuthNavigator,
    homeNavigator: HomeNavigator
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        NavHost(
            navController = navHostController,
            startDestination = "signIn/{id}/{password}/{nickname}/{phoneNumber}"
        ) {
            authNavGraph(authNavigator)
            homeNavGraph(homeNavigator)
        }
    }
}