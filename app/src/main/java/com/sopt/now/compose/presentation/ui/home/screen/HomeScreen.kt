package com.sopt.now.compose.presentation.ui.home.screen

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.R
import com.sopt.now.compose.presentation.ui.home.component.UserInfoText
import com.sopt.now.compose.presentation.ui.home.navigation.HomeNavigator
import com.sopt.now.compose.presentation.utils.showToast
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun HomeRoute(
    homeNavigator: HomeNavigator,
    id: String,
    password: String,
    nickname: String,
    phoneNumber: String,
) {
    var backPressedTime by remember { mutableLongStateOf(0L) }
    val backPressThreshold = 2000
    val context = LocalContext.current

    BackHandler {
        val currentTime = System.currentTimeMillis()
        if (currentTime - backPressedTime <= backPressThreshold) {
            (context as? Activity)?.finish()
        } else {
            backPressedTime = currentTime
            showToast(
                context = context,
                message = context.getString(R.string.home_backhandler_caution)
            )
        }
    }

    HomeScreen(
        id = id,
        password = password,
        nickname = nickname,
        phoneNumber = phoneNumber
    )
}

@Composable
fun HomeScreen(
    id: String,
    password: String,
    nickname: String,
    phoneNumber: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CustomTheme.colors.white)
            .padding(40.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = nickname,
                color = CustomTheme.colors.gray01,
                style = CustomTheme.typography.head1
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        UserInfoText(
            title = stringResource(R.string.home_id_title),
            value = id
        )
        Spacer(modifier = Modifier.height(30.dp))
        UserInfoText(
            title = stringResource(R.string.home_password_title),
            value = password
        )
        Spacer(modifier = Modifier.height(30.dp))
        UserInfoText(
            title = stringResource(R.string.home_phone_number_title),
            value = phoneNumber
        )
    }
}

@Preview(showBackground = true)
@Composable
fun showMain() {
    HomeScreen("유저 아이디", "유저 비밀번호", "유저 닉네임", "010-XXXX-XXXX")
}