package com.sopt.now.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.R
import com.sopt.now.data.User
import com.sopt.now.databinding.ActivityMainBinding
import com.sopt.now.presentation.utils.KeyStorage
import com.sopt.now.presentation.utils.getParcelable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getUserInfo()
        showUserInfo()
    }

    private fun getUserInfo() {
        user = intent.getParcelable(KeyStorage.USER_INFO, User::class.java) ?: User(
            getString(R.string.mypage_id_basic),
            getString(R.string.mypage_password_basic),
            getString(R.string.mypage_nickname_basic),
            getString(R.string.mypage_phone_number_basic)
        )
    }

    private fun showUserInfo() {
        with(binding) {
            tvMyPageNickname.text = user?.nickname
            tvMyPageIdContent.text = user?.id
            tvMyPagePwContent.text = user?.password
            tvMyPagePhoneNumberContent.text = user?.phoneNumber
        }
    }
}