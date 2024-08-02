package com.sopt.now.compose.presentation.ui.auth.screen

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.R
import com.sopt.now.compose.presentation.ui.auth.component.AuthTextField
import com.sopt.now.compose.presentation.ui.auth.component.SignInButton
import com.sopt.now.compose.presentation.ui.auth.component.SignUpTextButton
import com.sopt.now.compose.presentation.ui.auth.navigation.AuthNavigator
import com.sopt.now.compose.presentation.utils.showToast
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun SignInRoute(
    authNavigator: AuthNavigator,
    id: String,
    password: String,
    nickname: String,
    phoneNumber: String
) {
    SignInScreen(
        onClickSignIn = { id, password, nickname, phoneNumber ->
            authNavigator.navigateToHome(
                id,
                password,
                nickname,
                phoneNumber
            )
        },
        onClickSignUp = { authNavigator.navigateToSignUp() },
        id = id,
        password = password,
        nickname = nickname,
        phoneNumber = phoneNumber
    )
}

@Composable
fun SignInScreen(
    onClickSignIn: (String, String, String, String) -> Unit,
    onClickSignUp: () -> Unit,
    id: String,
    password: String,
    nickname: String,
    phoneNumber: String
) {
    val context = LocalContext.current
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
            text = stringResource(R.string.signin_title),
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 30.dp),
            style = CustomTheme.typography.head1
        )
        Spacer(modifier = Modifier.height(80.dp))
        AuthTextField(
            value = inputId,
            onValueChange = { inputId = it },
            modifier = Modifier
                .fillMaxWidth(),
            isFocused = isIdTextFieldFocused,
            onFocusChanged = { isIdTextFieldFocused = it },
            onRemove = { inputId = TextFieldValue("") },
            hint = stringResource(R.string.signin_id_hint)
        )
        Spacer(modifier = Modifier.height(40.dp))
        AuthTextField(
            value = inputPassword,
            onValueChange = { inputPassword = it },
            modifier = Modifier
                .fillMaxWidth(),
            isFocused = isPasswordTextFieldFocused,
            onFocusChanged = { isPasswordTextFieldFocused = it },
            onRemove = { inputPassword = TextFieldValue("") },
            isPassword = true,
            hint = stringResource(R.string.signin_password_hint)
        )
        Spacer(modifier = Modifier.height(40.dp))
        SignUpTextButton(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.End)
                .clickable { onClickSignUp() }
        )
        Spacer(modifier = Modifier.weight(1f))
        SignInButton(
            context = context,
            inputId = inputId.text,
            inputPassword = inputPassword.text,
            id = id,
            password = password,
            nickname = nickname,
            phoneNumber = phoneNumber,
            onClickSignIn = onClickSignIn
        )
    }
}

@Preview(showBackground = true)
@Composable
fun show() {

}