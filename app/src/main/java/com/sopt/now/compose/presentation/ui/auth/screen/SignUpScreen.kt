package com.sopt.now.compose.presentation.ui.auth.screen

import android.util.Log
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.R
import com.sopt.now.compose.presentation.ui.auth.component.AuthTextField
import com.sopt.now.compose.presentation.ui.auth.navigation.AuthNavigator
import com.sopt.now.compose.presentation.utils.showToast
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun SignUpRoute(
    authNavigator: AuthNavigator,
    authViewModel: AuthViewModel
) {
    val context = LocalContext.current

    fun onClickSignUp() {
        authViewModel.signUpValidation()
        when (authViewModel.signUpState.value) {
            is SignUpState.IdInvalid -> {
                showToast(context, context.getString(R.string.signup_id_invalid))
            }

            is SignUpState.PasswordInvalid -> {
                showToast(context, context.getString(R.string.signup_password_invalid))
            }

            is SignUpState.NicknameInvalid -> {
                showToast(context, context.getString(R.string.signup_nickname_invalid))
            }

            is SignUpState.PhoneNumberInvalid -> {
                showToast(context, context.getString(R.string.signup_phone_number_invalid))
            }

            is SignUpState.Success -> {
                showToast(context, context.getString(R.string.signup_signup_success))
                authNavigator.navigateToSignIn()
                Log.d("user_info", authViewModel.user.value.toString())
            }

            else -> {}
        }
    }

    SignUpScreen(
        authViewModel = authViewModel,
        onClickSignUp = { onClickSignUp() }
    )
}

@Composable
fun SignUpScreen(
    authViewModel: AuthViewModel,
    onClickSignUp: () -> Unit
) {
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
            modifier = Modifier.fillMaxWidth(),
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
                    value = authViewModel.signUpId,
                    onValueChange = { authViewModel.onSignUpIdChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    isFocused = authViewModel.isSignUpIdTextFieldFocused,
                    onFocusChanged = { authViewModel.onSignUpIdFocusChange(it) },
                    onRemove = { authViewModel.onSignUpIdChange("") },
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
                    value = authViewModel.signUpPassword,
                    onValueChange = { authViewModel.onSignUpPasswordChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    isFocused = authViewModel.isSignUpPasswordTextFieldFocused,
                    onFocusChanged = { authViewModel.onSignUpPasswordFocusChange(it) },
                    onRemove = { authViewModel.onSignUpPasswordChange("") },
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
                    value = authViewModel.signUpNickname,
                    onValueChange = { authViewModel.onSignUpNicknameChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    isFocused = authViewModel.isSignUpNicknameTextFieldFocused,
                    onFocusChanged = { authViewModel.onSignUpNicknameFocusChange(it) },
                    onRemove = { authViewModel.onSignUpNicknameChange("") },
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
                    value = authViewModel.signUpPhoneNumber,
                    onValueChange = { authViewModel.onSignUpPhoneNumberChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    isFocused = authViewModel.isSignUpPhoneNumberTextFieldFocused,
                    onFocusChanged = { authViewModel.onSignUpPhoneNumberFocusChange(it) },
                    onRemove = { authViewModel.onSignUpPhoneNumberChange("") },
                    hint = stringResource(R.string.signup_phone_number_hint),
                    focusRequester = phoneNumberFocusRequester
                )
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
        Button(
            onClick = onClickSignUp,
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


@Preview(showBackground = true)
@Composable
fun ShowSignUp() {

}