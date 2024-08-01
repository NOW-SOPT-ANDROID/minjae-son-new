package com.sopt.now.auth.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.MainActivity
import com.sopt.now.R
import com.sopt.now.auth.signup.SignUpActivity
import com.sopt.now.data.User
import com.sopt.now.databinding.ActivitySigninBinding
import com.sopt.now.utils.getParcelable
import com.sopt.now.utils.showToast

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getUserInfo()
        onSignInClicked()
        onSignUpClicked()
    }

    private fun getUserInfo() {
        user = intent.getParcelable("user", User::class.java)
    }

    private fun onSignInClicked() {
        binding.btnSignInSignIn.setOnClickListener {
            with(binding) {
                val inputId = etSignInId.text.toString()
                val inputPassword = etSignInPw.text.toString()

                if (inputId == user?.id && inputPassword == user?.password) {
                    showToast(this@SignInActivity, getString(R.string.signin_signin_success))
                    navigateToMain()
                } else {
                    showToast(this@SignInActivity, getString(R.string.signin_signin_failure))
                }
            }
        }
    }

    private fun onSignUpClicked() {
        binding.btnSignInSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun navigateToMain() {
        val intent = Intent(this@SignInActivity, MainActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    private fun navigateToSignUp() {
        val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
        startActivity(intent)
    }
}