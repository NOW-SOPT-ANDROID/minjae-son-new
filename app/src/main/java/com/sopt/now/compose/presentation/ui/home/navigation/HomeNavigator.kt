package com.sopt.now.compose.presentation.ui.home.navigation

import androidx.navigation.NavController

class HomeNavigator(
    private val navController: NavController
) {
    fun navigateToBack() {
        navController.popBackStack()
    }
}