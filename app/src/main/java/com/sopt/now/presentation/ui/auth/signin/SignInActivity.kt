package com.sopt.now.presentation.ui.auth.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sopt.now.R
import com.sopt.now.data.User
import com.sopt.now.databinding.ActivitySigninBinding
import com.sopt.now.presentation.ui.MainActivity
import com.sopt.now.presentation.ui.auth.signup.SignUpActivity
import com.sopt.now.presentation.utils.KeyStorage
import com.sopt.now.presentation.utils.getSafeParcelable
import com.sopt.now.presentation.utils.showToast

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        getUserInfo()
        onSignInClicked()
        onSignUpClicked()
    }

    private fun getUserInfo() {
        val user = intent.getSafeParcelable(KeyStorage.USER_INFO, User::class.java)
        viewModel.setUser(user)
    }

    private fun setupObservers() {
        viewModel.signInState.observe(this) { isSuccess ->
            if (isSuccess) {
                showToast(this, getString(R.string.signin_signin_success))
                navigateToMain(viewModel.user.value)
            } else {
                showToast(this, getString(R.string.signin_signin_failure))
            }
        }
    }

    private fun onSignInClicked() {
        binding.btnSignInSignIn.setOnClickListener {
            with(binding) {
                val inputId = etSignInId.text.toString()
                val inputPassword = etSignInPw.text.toString()
                viewModel.validateSignIn(inputId, inputPassword)
            }
            setupObservers()
        }
    }

    private fun onSignUpClicked() {
        binding.btnSignInSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun navigateToMain(user: User?) {
        val intent = Intent(this@SignInActivity, MainActivity::class.java)
        intent.putExtra(KeyStorage.USER_INFO, user)
        startActivity(intent)
    }

    private fun navigateToSignUp() {
        val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
        startActivity(intent)
    }
}