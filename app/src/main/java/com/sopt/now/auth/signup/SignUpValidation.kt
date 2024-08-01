package com.sopt.now.auth.signup

import com.sopt.now.data.User

class SignUpValidation {
    companion object {
        private const val ID_MIN_LENGTH = 6
        private const val ID_MAX_LENGTH = 10
        private const val PW_MIN_LENGTH = 8
        private const val PW_MAX_LENGTH = 12

        private fun isIdValid(inputId: String): Boolean {
            val regex = "^[a-zA-Z0-9]{$ID_MIN_LENGTH,$ID_MAX_LENGTH}$".toRegex()
            return regex.matches(inputId)
        }

        private fun isPasswordValid(inputPassword: String): Boolean {
            val regex = "^[a-zA-Z0-9]{$PW_MIN_LENGTH,$PW_MAX_LENGTH}$".toRegex()
            return regex.matches(inputPassword)
        }

        private fun isNicknameValid(inputNickname: String): Boolean {
            val regex = "^\\S+$".toRegex()
            return regex.matches(inputNickname)
        }

        private fun isPhoneNumberValid(inputPhoneNumber: String): Boolean {
            val regex = "^010-\\d{4}-\\d{4}$".toRegex()
            return regex.matches(inputPhoneNumber)
        }

        fun isSignUpValid(user: User): Boolean {
            return isIdValid(user.id) &&
                    isPasswordValid(user.password) &&
                    isNicknameValid(user.nickname) &&
                    isPhoneNumberValid(user.phoneNumber)
        }
    }
}