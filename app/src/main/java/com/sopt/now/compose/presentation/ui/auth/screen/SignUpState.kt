package com.sopt.now.compose.presentation.ui.auth.screen

sealed class SignUpState {
    data object Idle: SignUpState()
    data object IdInvalid: SignUpState()
    data object PasswordInvalid: SignUpState()
    data object NicknameInvalid: SignUpState()
    data object PhoneNumberInvalid: SignUpState()
    data object Success: SignUpState()
}