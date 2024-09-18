package com.sopt.now.compose.presentation.ui.auth.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.R
import com.sopt.now.compose.data.User
import com.sopt.now.compose.presentation.ui.auth.component.AuthTextField
import com.sopt.now.compose.presentation.ui.auth.navigation.AuthNavigator
import com.sopt.now.compose.presentation.utils.showToast
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun SignUpRoute(
    authNavigator: AuthNavigator
) {
    SignUpScreen(
        onClickSignUp = { id, password, nickname, phoneNumber ->
            authNavigator.navigateToSignIn(
                id,
                password,
                nickname,
                phoneNumber
            )
        }
    )
}

@Composable
fun SignUpScreen(
    onClickSignUp: (String, String, String, String) -> Unit
) {
    val context = LocalContext.current

    var inputId by remember { mutableStateOf(TextFieldValue("")) }
    var inputPassword by remember { mutableStateOf(TextFieldValue("")) }
    var inputNickname by remember { mutableStateOf(TextFieldValue("")) }
    var inputPhoneNumber by remember { mutableStateOf(TextFieldValue("")) }

    var isIdTextFieldFocused by remember { mutableStateOf(false) }
    var isPasswordTextFieldFocused by remember { mutableStateOf(false) }
    var isNicknameTextFieldFocused by remember { mutableStateOf(false) }
    var isPhoneNumberTextFieldFocused by remember { mutableStateOf(false) }

    val idFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }
    val nicknameFocusRequester = remember { FocusRequester() }
    val phoneNumberFocusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CustomTheme.colors.white)
            .padding(30.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp),
            horizontalAlignment = Alignment.Start
        ) {
            item {
                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = stringResource(R.string.signup_title),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = CustomTheme.typography.head1
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = stringResource(R.string.signup_id_title),
                    style = CustomTheme.typography.head2
                )
                Spacer(modifier = Modifier.height(18.dp))
                AuthTextField(
                    value = inputId,
                    onValueChange = { inputId = it },
                    modifier = Modifier.fillMaxWidth(),
                    isFocused = isIdTextFieldFocused,
                    onFocusChanged = { isIdTextFieldFocused = it },
                    onRemove = { inputId = TextFieldValue("") },
                    hint = stringResource(R.string.signup_id_hint),
                    focusRequester = idFocusRequester,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { passwordFocusRequester.requestFocus() })
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = stringResource(R.string.signup_password_title),
                    style = CustomTheme.typography.head2
                )
                Spacer(modifier = Modifier.height(18.dp))
                AuthTextField(
                    value = inputPassword,
                    onValueChange = { inputPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    isFocused = isPasswordTextFieldFocused,
                    onFocusChanged = { isPasswordTextFieldFocused = it },
                    onRemove = { inputPassword = TextFieldValue("") },
                    hint = stringResource(R.string.signup_password_hint),
                    visualTransformation = PasswordVisualTransformation(),
                    focusRequester = passwordFocusRequester,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { nicknameFocusRequester.requestFocus() })
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = stringResource(R.string.signup_nickname_title),
                    style = CustomTheme.typography.head2
                )
                Spacer(modifier = Modifier.height(18.dp))
                AuthTextField(
                    value = inputNickname,
                    onValueChange = { inputNickname = it },
                    modifier = Modifier.fillMaxWidth(),
                    isFocused = isNicknameTextFieldFocused,
                    onFocusChanged = { isNicknameTextFieldFocused = it },
                    onRemove = { inputNickname = TextFieldValue("") },
                    hint = stringResource(R.string.signup_nickname_hint),
                    focusRequester = nicknameFocusRequester,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { phoneNumberFocusRequester.requestFocus() })
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = stringResource(R.string.signup_phone_number_title),
                    style = CustomTheme.typography.head2
                )
                Spacer(modifier = Modifier.height(18.dp))
                AuthTextField(
                    value = inputPhoneNumber,
                    onValueChange = { inputPhoneNumber = it },
                    modifier = Modifier.fillMaxWidth(),
                    isFocused = isPhoneNumberTextFieldFocused,
                    onFocusChanged = { isPhoneNumberTextFieldFocused = it },
                    onRemove = { inputPhoneNumber = TextFieldValue("") },
                    hint = stringResource(R.string.signup_phone_number_hint),
                    focusRequester = phoneNumberFocusRequester
                )
            }
        }
        Button(
            onClick = {
                val user = setUser(
                    inputId.text,
                    inputPassword.text,
                    inputNickname.text,
                    inputPhoneNumber.text
                )
                if (SignUpValidation.isSignUpValid(user)) {
                    showToast(context, context.getString(R.string.signup_signup_success))
                    onClickSignUp(
                        inputId.text,
                        inputPassword.text,
                        inputNickname.text,
                        inputPhoneNumber.text
                    )
                } else {
                    showToast(context, context.getString(R.string.signup_signup_failure))
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(CustomTheme.colors.mainYellow),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = stringResource(R.string.signup_signup_button),
                color = CustomTheme.colors.gray01
            )
        }
    }
}


fun setUser(
    inputId: String,
    inputPassword: String,
    inputNickname: String,
    inputPhoneNumber: String
): User = User(
    id = inputId,
    password = inputPassword,
    nickname = inputNickname,
    phoneNumber = inputPhoneNumber
)


@Preview(showBackground = true)
@Composable
fun ShowSignUp() {
    SignUpScreen(onClickSignUp = { id, password, nickname, phoneNumber -> })
}