package com.sopt.now.compose.presentation.home.screen

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.R
import com.sopt.now.compose.presentation.home.navigation.HomeNavigator
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun HomeRoute(
    homeNavigator: HomeNavigator
) {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    var nickname by remember { mutableStateOf("유저 닉네임") }
    var userId by remember { mutableStateOf("유저 아이디") }
    var userPassword by remember { mutableStateOf("유저 비밀번호") }
    var userPhoneNumber by remember { mutableStateOf("010-XXXX-XXXX") }

    Column(
        modifier = Modifier
            .fillMaxSize()
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
        Text(
            text = "아이디",
            color = CustomTheme.colors.gray01,
            style = CustomTheme.typography.head2
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = userId,
            color = CustomTheme.colors.gray03,
            style = CustomTheme.typography.body1Medium
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "비밀번호",
            color = CustomTheme.colors.gray01,
            style = CustomTheme.typography.head2
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = userPassword,
            color = CustomTheme.colors.gray03,
            style = CustomTheme.typography.body1Medium
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "전화번호",
            color = CustomTheme.colors.gray01,
            style = CustomTheme.typography.head2
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = userPhoneNumber,
            color = CustomTheme.colors.gray03,
            style = CustomTheme.typography.body1Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun showMain() {
    HomeScreen()
}