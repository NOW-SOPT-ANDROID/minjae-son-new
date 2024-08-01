package com.sopt.now.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.data.User
import com.sopt.now.databinding.ActivityMainBinding
import com.sopt.now.presentation.utils.getParcelable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelable("user", User::class.java)

        with(binding) {
            tvMyPageNickname.text = user?.nickname
            tvMyPageIdContent.text = user?.id
            tvMyPagePwContent.text = user?.password
            tvMyPagePhoneNumberContent.text = user?.phoneNumber
        }
    }
}