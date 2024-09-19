package com.sopt.now.presentation.ui.auth.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.now.data.User

class SignInViewModel : ViewModel() {
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    private val _signInState = MutableLiveData<Boolean>()
    val signInState: LiveData<Boolean> = _signInState

    fun setUser(user: User?) {
        _user.value = user
    }

    fun validateSignIn(inputId: String, inputPassword: String) {
        if (inputId == _user.value?.id && inputPassword == _user.value?.password) {
            _signInState.value = true
        } else {
            _signInState.value = false
        }
    }
}
