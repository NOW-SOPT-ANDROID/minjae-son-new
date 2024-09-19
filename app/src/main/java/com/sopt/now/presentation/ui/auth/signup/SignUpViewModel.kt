package com.sopt.now.presentation.ui.auth.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.now.data.User
import java.util.regex.Pattern

class SignUpViewModel() : ViewModel() {
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    private val _signUpState = MutableLiveData(false)
    val signUpState: LiveData<Boolean> = _signUpState

    fun setUser(user: User) {
        _user.value = user
    }

    private fun isIdValid(): Boolean {
        return ID_VALIDATION_PATTERN.matcher(_user.value?.id ?: "").matches()
    }

    private fun isPasswordValid(): Boolean {
        return PW_VALIDATION_PATTERN.matcher(_user.value?.password ?: "").matches()
    }

    private fun isNicknameValid(): Boolean {
        return NICKNAME_VALIDATION_PATTERN.matcher(_user.value?.nickname ?: "").matches()
    }

    private fun isPhoneNumberValid(): Boolean {
        return PHONE_NUMBER_VALIDATION_PATTERN.matcher(_user.value?.phoneNumber ?: "").matches()
    }

    fun validateSignUp() {
        _signUpState.value = isIdValid() &&
                isPasswordValid() &&
                isNicknameValid() &&
                isPhoneNumberValid()
    }

    companion object {
        private const val ID_MIN_LENGTH = 6
        private const val ID_MAX_LENGTH = 10
        private const val PW_MIN_LENGTH = 8
        private const val PW_MAX_LENGTH = 12

        private const val ID_VALIDATION_REGEX = "^[a-zA-Z0-9]{$ID_MIN_LENGTH,$ID_MAX_LENGTH}$"
        private val ID_VALIDATION_PATTERN: Pattern = Pattern.compile(ID_VALIDATION_REGEX)

        private const val PW_VALIDATION_REGEX = "^[a-zA-Z0-9]{$PW_MIN_LENGTH,$PW_MAX_LENGTH}$"
        private val PW_VALIDATION_PATTERN: Pattern = Pattern.compile(PW_VALIDATION_REGEX)

        private const val NICKNAME_VALIDATION_REGEX = "^\\S+$"
        private val NICKNAME_VALIDATION_PATTERN: Pattern =
            Pattern.compile(NICKNAME_VALIDATION_REGEX)

        private const val PHONE_NUMBER_VALIDATION_REGEX = "^010-\\d{4}-\\d{4}$"
        private val PHONE_NUMBER_VALIDATION_PATTERN: Pattern =
            Pattern.compile(PHONE_NUMBER_VALIDATION_REGEX)
    }
}
