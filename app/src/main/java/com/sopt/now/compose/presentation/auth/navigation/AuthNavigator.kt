package com.sopt.now.compose.presentation.auth.navigation

import androidx.navigation.NavController

class AuthNavigator(
    private val navController: NavController
) {
    fun navigateToSignIn() {
        navController.navigate("signIn")
    }

    fun navigateToSignUp() {
        navController.navigate("signUp")
    }

    fun navigateToHome() {
        navController.navigate("home")
    }

    fun navigateToBack() {
        navController.popBackStack()
    }
}