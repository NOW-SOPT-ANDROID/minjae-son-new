package com.sopt.now.compose.presentation.ui.auth.navigation

import androidx.navigation.NavController

class AuthNavigator(
    private val navController: NavController
) {
    fun navigateToSignIn(id: String, password: String, nickname: String, phoneNumber: String) {
        navController.navigate("signIn/$id/$password/$nickname/$phoneNumber")
    }

    fun navigateToSignUp() {
        navController.navigate("signUp")
    }

    fun navigateToHome(id: String, password: String, nickname: String, phoneNumber: String) {
        navController.navigate("home/$id/$password/$nickname/$phoneNumber")
    }

    fun navigateToBack() {
        navController.navigateUp()
    }
}