package com.sopt.now.compose.presentation.auth.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
import com.sopt.now.compose.presentation.auth.component.PasswordTextField
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun SignInScreen() {

    var inputId by remember { mutableStateOf(TextFieldValue("")) }
    var inputPassword by remember { mutableStateOf(TextFieldValue("")) }
    var isIdTextFieldFocused by remember { mutableStateOf(false) }
    var isPasswordTextFieldFocused by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome To SOPT",
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 30.dp),
            style = CustomTheme.typography.head1
        )
        Spacer(modifier = Modifier.height(80.dp))
        IdTextField(
            value = inputId,
            onValueChange = { inputId = it },
            modifier = Modifier
                .fillMaxWidth(),
            isFocused = isIdTextFieldFocused,
            onFocusChanged = { isIdTextFieldFocused = it },
            onRemove = { inputId = TextFieldValue("") }
        )
        Spacer(modifier = Modifier.height(40.dp))
        PasswordTextField(
            value = inputPassword,
            onValueChange = { inputPassword = it },
            modifier = Modifier
                .fillMaxWidth(),
            isFocused = isPasswordTextFieldFocused,
            onFocusChanged = { isPasswordTextFieldFocused = it },
            onRemove = { inputPassword = TextFieldValue("") }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.End)
                .clickable { /* TODO : 회원가입으로 이동 */ },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "회원가입",
                color = CustomTheme.colors.gray04,
                style = CustomTheme.typography.body2Medium
            )
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .width(60.dp)
                    .background(CustomTheme.colors.gray04)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /* TODO : 로그인 성공 시, 메인화면으로 이동 */ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(CustomTheme.colors.mainYellow),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "로그인 하기",
                color = CustomTheme.colors.gray01
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun show() {
    SignInScreen()
}