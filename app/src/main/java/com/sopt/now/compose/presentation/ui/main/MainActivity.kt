package com.sopt.now.compose.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.sopt.now.compose.presentation.ui.auth.navigation.AuthNavigator
import com.sopt.now.compose.presentation.ui.auth.screen.AuthViewModel
import com.sopt.now.compose.presentation.ui.home.navigation.HomeNavigator
import com.sopt.now.compose.presentation.ui.navigator.MainNavHost
import com.sopt.now.compose.ui.theme.CUSTOMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CUSTOMTheme {
                val navController = rememberNavController()
                val authNavigator = remember(navController) { AuthNavigator(navController) }
                val authViewModel: AuthViewModel = hiltViewModel()
                val homeNavigator = remember(navController) { HomeNavigator(navController) }

                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background,
                    content = { paddingValues ->
                        MainNavHost(
                            navHostController = navController,
                            modifier = Modifier.padding(paddingValues),
                            authNavigator = authNavigator,
                            authViewModel = authViewModel,
                            homeNavigator = homeNavigator
                        )
                    }
                )
            }
        }
    }
}