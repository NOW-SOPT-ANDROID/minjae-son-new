package com.sopt.now.presentation.ui.auth.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sopt.now.R
import com.sopt.now.data.User
import com.sopt.now.databinding.ActivitySignupBinding
import com.sopt.now.presentation.ui.auth.signin.SignInActivity
import com.sopt.now.presentation.utils.KeyStorage
import com.sopt.now.presentation.utils.showToast

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        onSignUpClicked()
    }

    private fun setupObservers() {
        viewModel.signUpState.observe(this) { isSuccess ->
            if (isSuccess) {
                showToast(this@SignUpActivity, getString(R.string.signup_signup_success))
                navigateToSignIn(viewModel.user.value)
            } else {
                showToast(this@SignUpActivity, getString(R.string.signup_signup_failure))
            }
        }
    }

    private fun onSignUpClicked() {
        binding.btnSignUpSignUp.setOnClickListener {
            with(binding) {
                val user = User(
                    etSignUpId.text.toString(),
                    etSignUpPw.text.toString(),
                    etSignUpNickname.text.toString(),
                    etSignUpPhoneNumber.text.toString()
                )
                viewModel.setUser(user)
            }
            viewModel.validateSignUp()
            setupObservers()
        }
    }

    private fun navigateToSignIn(user: User?) {
        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
        intent.putExtra(KeyStorage.USER_INFO, user)
        startActivity(intent)
    }
}