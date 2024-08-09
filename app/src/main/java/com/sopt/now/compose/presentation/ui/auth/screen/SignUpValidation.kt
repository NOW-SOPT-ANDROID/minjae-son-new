package com.sopt.now.compose.presentation.ui.auth.screen

import com.sopt.now.compose.data.User
import java.util.regex.Pattern

object SignUpValidation {

    private const val ID_MIN_LENGTH = 6
    private const val ID_MAX_LENGTH = 10
    private const val PW_MIN_LENGTH = 8
    private const val PW_MAX_LENGTH = 12

    private const val ID_VALIDATION_REGEX = "^[a-zA-Z0-9]{$ID_MIN_LENGTH,$ID_MAX_LENGTH}$"
    private val ID_VALIDATION_PATTERN: Pattern = Pattern.compile(ID_VALIDATION_REGEX)

    private const val PW_VALIDATION_REGEX = "^[a-zA-Z0-9]{$PW_MIN_LENGTH,$PW_MAX_LENGTH}$"
    private val PW_VALIDATION_PATTERN: Pattern = Pattern.compile(PW_VALIDATION_REGEX)

    private const val NICKNAME_VALIDATION_REGEX = "^\\S+$"
    private val NICKNAME_VALIDATION_PATTERN: Pattern = Pattern.compile(NICKNAME_VALIDATION_REGEX)

    private const val PHONE_NUMBER_VALIDATION_REGEX = "^010-\\d{4}-\\d{4}$"
    private val PHONE_NUMBER_VALIDATION_PATTERN: Pattern = Pattern.compile(PHONE_NUMBER_VALIDATION_REGEX)

    private fun isIdValid(inputId: String): Boolean {
        return ID_VALIDATION_PATTERN.matcher(inputId).matches()
    }

    private fun isPasswordValid(inputPassword: String): Boolean {
        return PW_VALIDATION_PATTERN.matcher(inputPassword).matches()
    }

    private fun isNicknameValid(inputNickname: String): Boolean {
        return NICKNAME_VALIDATION_PATTERN.matcher(inputNickname).matches()
    }

    private fun isPhoneNumberValid(inputPhoneNumber: String): Boolean {
        return PHONE_NUMBER_VALIDATION_PATTERN.matcher(inputPhoneNumber).matches()
    }

    fun isSignUpValid(user: User): Boolean {
        return isIdValid(user.id) &&
                isPasswordValid(user.password) &&
                isNicknameValid(user.nickname) &&
                isPhoneNumberValid(user.phoneNumber)
    }
}