package com.sopt.now.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.R
import com.sopt.now.data.User
import com.sopt.now.databinding.ActivityMainBinding
import com.sopt.now.presentation.utils.KeyStorage
import com.sopt.now.presentation.utils.getSafeParcelable
import com.sopt.now.presentation.utils.showToast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var user: User? = null
    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getUserInfo()
        showUserInfo()

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (System.currentTimeMillis() - backPressedTime < 2000) {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()

                    val intent = Intent(Intent.ACTION_MAIN)
                    intent.addCategory(Intent.CATEGORY_HOME)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    finish()
                } else {
                    showToast(
                        context = this@MainActivity,
                        message = getString(R.string.mypage_back_handler_caution)
                    )
                    backPressedTime = System.currentTimeMillis()
                }
            }
        })

    }

    private fun getUserInfo() {
        user = intent.getSafeParcelable(KeyStorage.USER_INFO, User::class.java) ?: User(
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
