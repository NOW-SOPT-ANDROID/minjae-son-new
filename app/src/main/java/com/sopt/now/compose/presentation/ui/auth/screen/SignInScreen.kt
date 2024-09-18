package com.sopt.now.compose.presentation.ui.auth.screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.R
import com.sopt.now.compose.presentation.ui.auth.component.AuthTextField
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

    val idFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CustomTheme.colors.white)
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
            hint = stringResource(R.string.signin_id_hint),
            focusRequester = idFocusRequester,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { passwordFocusRequester.requestFocus() })
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
            hint = stringResource(R.string.signin_password_hint),
            visualTransformation = PasswordVisualTransformation(),
            focusRequester = passwordFocusRequester,
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(R.string.signin_signup_button),
            modifier = Modifier
                .align(Alignment.End)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onClickSignUp
                ),
            color = CustomTheme.colors.gray04,
            textDecoration = TextDecoration.Underline,
            style = CustomTheme.typography.body2Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        SignInButton(
            modifier = Modifier
                .fillMaxWidth(),
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

@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    context: Context,
    inputId: String,
    inputPassword: String,
    id: String,
    password: String,
    nickname: String,
    phoneNumber: String,
    onClickSignIn: (String, String, String, String) -> Unit
) {
    Button(
        onClick = {
            when {
                inputId.isEmpty() || inputPassword.isEmpty() -> showToast(
                    context,
                    context.getString(R.string.signin_signin_failure_toast)
                )

                inputId != id -> showToast(
                    context,
                    context.getString(R.string.signin_signin_id_incorrect)
                )

                inputPassword != password -> showToast(
                    context,
                    context.getString(R.string.signin_signin_password_incorrect)
                )

                else -> {
                    showToast(context, context.getString(R.string.signin_signin_success_toast))
                    onClickSignIn(id, password, nickname, phoneNumber)
                }
            }
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(CustomTheme.colors.mainYellow),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(R.string.signin_signin_button),
            color = CustomTheme.colors.gray01
        )
    }
}

@Preview(showBackground = true)
@Composable
fun show() {

}