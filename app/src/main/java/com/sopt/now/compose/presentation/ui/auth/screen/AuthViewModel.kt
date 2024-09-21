package com.sopt.now.compose.presentation.ui.auth.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sopt.now.compose.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    var signInId by mutableStateOf("")
        private set
    var signInPassword by mutableStateOf("")
        private set
    var signUpId by mutableStateOf("")
        private set
    var signUpPassword by mutableStateOf("")
        private set
    var signUpNickname by mutableStateOf("")
        private set
    var signUpPhoneNumber by mutableStateOf("")
        private set

    var isSignInIdTextFieldFocused by mutableStateOf(false)
        private set
    var isSignInPasswordTextFieldFocused by mutableStateOf(false)
        private set
    var isSignUpIdTextFieldFocused by mutableStateOf(false)
        private set
    var isSignUpPasswordTextFieldFocused by mutableStateOf(false)
        private set
    var isSignUpNicknameTextFieldFocused by mutableStateOf(false)
        private set
    var isSignUpPhoneNumberTextFieldFocused by mutableStateOf(false)
        private set

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _signInState = MutableStateFlow<SignInState>(SignInState.Idle)
    val signInState: StateFlow<SignInState> = _signInState

    private val _signUpState = MutableStateFlow<SignUpState>(SignUpState.Idle)
    val signUpState: StateFlow<SignUpState> = _signUpState

    fun onSignInIdChange(newId: String) {
        signInId = newId
    }

    fun onSignInPasswordChange(newPassword: String) {
        signInPassword = newPassword
    }

    fun onSignInIdFocusChange(isFocused: Boolean) {
        isSignInIdTextFieldFocused = isFocused
    }

    fun onSignInPasswordFocusChange(isFocused: Boolean) {
        isSignInPasswordTextFieldFocused = isFocused
    }

    private fun signInIdValidation(): Boolean {
        return signInId.isNotEmpty() && signInId == _user.value?.id
    }

    private fun signInPasswordValidation(): Boolean {
        return signInPassword.isNotEmpty() && signInPassword == _user.value?.password
    }

    fun signInValidation() {
        _signInState.value =
            when {
                (!signInIdValidation()) -> SignInState.IdInvalid
                (!signInPasswordValidation()) -> SignInState.PasswordInvalid
                else -> SignInState.Success
            }
    }

    fun onSignUpIdChange(newId: String) {
        signUpId = newId
    }

    fun onSignUpPasswordChange(newPassword: String) {
        signUpPassword = newPassword
    }

    fun onSignUpNicknameChange(newNickname: String) {
        signUpNickname = newNickname
    }

    fun onSignUpPhoneNumberChange(newPhoneNumber: String) {
        signUpPhoneNumber = newPhoneNumber
    }

    fun onSignUpIdFocusChange(isFocused: Boolean) {
        isSignUpIdTextFieldFocused = isFocused
    }

    fun onSignUpPasswordFocusChange(isFocused: Boolean) {
        isSignUpPasswordTextFieldFocused = isFocused
    }

    fun onSignUpNicknameFocusChange(isFocused: Boolean) {
        isSignUpNicknameTextFieldFocused = isFocused
    }

    fun onSignUpPhoneNumberFocusChange(isFocused: Boolean) {
        isSignUpPhoneNumberTextFieldFocused = isFocused
    }

    private fun setUser() {
        _user.value = User(
            id = signUpId,
            password = signUpPassword,
            nickname = signUpNickname,
            phoneNumber = signUpPhoneNumber
        )
    }

    private fun signUpIdValidation(): Boolean {
        return ID_VALIDATION_PATTERN.matcher(_user.value?.id.toString()).matches()
    }

    private fun signUpPasswordValidation(): Boolean {
        return PW_VALIDATION_PATTERN.matcher(_user.value?.password.toString()).matches()
    }

    private fun signUpNicknameValidation(): Boolean {
        return NICKNAME_VALIDATION_PATTERN.matcher(_user.value?.nickname.toString()).matches()
    }

    private fun signUpPhoneNumberValidation(): Boolean {
        return PHONE_NUMBER_VALIDATION_PATTERN.matcher(_user.value?.phoneNumber.toString())
            .matches()
    }

    fun signUpValidation() {
        setUser()
        _signUpState.value =
            when {
                (!signUpIdValidation()) -> SignUpState.IdInvalid
                (!signUpPasswordValidation()) -> SignUpState.PasswordInvalid
                (!signUpNicknameValidation()) -> SignUpState.NicknameInvalid
                (!signUpPhoneNumberValidation()) -> SignUpState.PhoneNumberInvalid
                else -> SignUpState.Success
            }
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