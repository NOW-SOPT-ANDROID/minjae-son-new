package com.sopt.now.compose.presentation.ui.auth.screen

sealed class SignInState {
    data object Idle: SignInState()
    data object IdInvalid: SignInState()
    data object PasswordInvalid: SignInState()
    data object Success: SignInState()
}