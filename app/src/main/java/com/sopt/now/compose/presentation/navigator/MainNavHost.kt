package com.sopt.now.compose.presentation.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sopt.now.compose.presentation.auth.navigation.authNavGraph
import com.sopt.now.compose.presentation.auth.navigation.AuthNavigator
import com.sopt.now.compose.presentation.home.navigation.homeNavGraph
import com.sopt.now.compose.presentation.home.navigation.HomeNavigator

@Composable
fun MainNavHost(
    navController: NavHostController,
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
            navController = navController,
            startDestination = "signIn"
        ) {
            authNavGraph(authNavigator, homeNavigator)
            homeNavGraph(homeNavigator)
        }
    }
}