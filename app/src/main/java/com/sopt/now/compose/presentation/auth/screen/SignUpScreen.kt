package com.sopt.now.compose.presentation.auth.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.presentation.auth.component.IdTextField
import com.sopt.now.compose.presentation.auth.component.NicknameTextField
import com.sopt.now.compose.presentation.auth.component.PasswordTextField
import com.sopt.now.compose.presentation.auth.component.PhoneNumberTextField
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun SignUpScreen() {
    var userId by remember { mutableStateOf(TextFieldValue("")) }
    var userPassword by remember { mutableStateOf(TextFieldValue("")) }
    var userNickname by remember { mutableStateOf(TextFieldValue("")) }
    var userPhoneNumber by remember { mutableStateOf(TextFieldValue("")) }

    var isIdTextFieldFocused by remember { mutableStateOf(false) }
    var isPasswordTextFieldFocused by remember { mutableStateOf(false) }
    var isNicknameTextFieldFocused by remember { mutableStateOf(false) }
    var isPhoneNumberTextFieldFocused by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SIGN UP",
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 30.dp),
            style = CustomTheme.typography.head1
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "아이디",
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Start),
            style = CustomTheme.typography.head2
        )
        Spacer(modifier = Modifier.height(18.dp))
        IdTextField(
            value = userId,
            onValueChange = { userId = it },
            modifier = Modifier
                .fillMaxWidth(),
            isFocused = isIdTextFieldFocused,
            onFocusChanged = { isIdTextFieldFocused = it },
            onRemove = { userId = TextFieldValue("") }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "비밀번호",
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Start),
            style = CustomTheme.typography.head2
        )
        Spacer(modifier = Modifier.height(18.dp))
        PasswordTextField(
            value = userPassword,
            onValueChange = { userPassword = it },
            modifier = Modifier
                .fillMaxWidth(),
            isFocused = isPasswordTextFieldFocused,
            onFocusChanged = { isPasswordTextFieldFocused = it },
            onRemove = { userPassword = TextFieldValue("") }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "닉네임",
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Start),
            style = CustomTheme.typography.head2
        )
        Spacer(modifier = Modifier.height(18.dp))
        NicknameTextField(
            value = userNickname,
            onValueChange = { userNickname = it },
            modifier = Modifier
                .fillMaxWidth(),
            isFocused = isNicknameTextFieldFocused,
            onFocusChanged = { isNicknameTextFieldFocused = it },
            onRemove = { userNickname = TextFieldValue("") }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "전화번호",
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Start),
            style = CustomTheme.typography.head2
        )
        Spacer(modifier = Modifier.height(18.dp))
        PhoneNumberTextField(
            value = userPhoneNumber,
            onValueChange = { userPhoneNumber = it },
            modifier = Modifier
                .fillMaxWidth(),
            isFocused = isPhoneNumberTextFieldFocused,
            onFocusChanged = { isPhoneNumberTextFieldFocused = it },
            onRemove = { userPhoneNumber = TextFieldValue("") }
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /* TODO : 회원가입 성공 시, 로그인 화면으로 이동 */ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(CustomTheme.colors.mainYellow),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "회원가입 하기",
                color = CustomTheme.colors.gray01
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showSignUp() {
    SignUpScreen()
}