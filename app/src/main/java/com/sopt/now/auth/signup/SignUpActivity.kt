package com.sopt.now.auth.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.auth.signin.SignInActivity
import com.sopt.now.data.User
import com.sopt.now.databinding.ActivitySignupBinding
import com.sopt.now.utils.showToast

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onSignUpClicked()
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

                if (SignUpValidation.isSignUpValid(user)
                ) {
                    showToast(this@SignUpActivity, "회원가입에 성공했습니다.")
                    val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                } else {
                    showToast(this@SignUpActivity, "회원가입에 실패했습니다.")
                }
            }
        }
    }
}








