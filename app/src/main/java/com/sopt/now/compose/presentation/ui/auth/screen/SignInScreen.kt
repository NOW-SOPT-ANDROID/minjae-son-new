package com.sopt.now.compose.presentation.ui.auth.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
    authViewModel: AuthViewModel
) {
    val context = LocalContext.current

    fun onClickSignIn() {
        authViewModel.signInValidation()
        when (authViewModel.signInState.value) {
            is SignInState.IdInvalid -> {
                showToast(context, context.getString(R.string.signin_signin_id_incorrect))
            }

            is SignInState.PasswordInvalid -> {
                showToast(context, context.getString(R.string.signin_signin_password_incorrect))
            }

            is SignInState.Success -> {
                showToast(context, context.getString(R.string.signin_signin_success_toast))
                authNavigator.navigateToHome(
                    authViewModel.user.value?.id,
                    authViewModel.user.value?.password,
                    authViewModel.user.value?.nickname,
                    authViewModel.user.value?.phoneNumber,
                )
            }

            else -> {}
        }
    }

    SignInScreen(
        authViewModel = authViewModel,
        onClickSignIn = { onClickSignIn() },
        onClickSignUp = { authNavigator.navigateToSignUp() },
    )
}

@Composable
fun SignInScreen(
    authViewModel: AuthViewModel,
    onClickSignIn: () -> Unit,
    onClickSignUp: () -> Unit,
) {
    val idFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CustomTheme.colors.white)
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(R.string.signin_title),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = CustomTheme.typography.head1
        )
        Spacer(modifier = Modifier.height(80.dp))
        AuthTextField(
            value = authViewModel.signInId,
            onValueChange = { authViewModel.onSignInIdChange(it) },
            modifier = Modifier.fillMaxWidth(),
            isFocused = authViewModel.isSignInIdTextFieldFocused,
            onFocusChanged = { authViewModel.onSignInIdFocusChange(it) },
            onRemove = { authViewModel.onSignInIdChange("") },
            hint = stringResource(R.string.signin_id_hint),
            focusRequester = idFocusRequester,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { passwordFocusRequester.requestFocus() })
        )
        Spacer(modifier = Modifier.height(40.dp))
        AuthTextField(
            value = authViewModel.signInPassword,
            onValueChange = { authViewModel.onSignInPasswordChange(it) },
            modifier = Modifier.fillMaxWidth(),
            isFocused = authViewModel.isSignInPasswordTextFieldFocused,
            onFocusChanged = { authViewModel.onSignInPasswordFocusChange(it) },
            onRemove = { authViewModel.onSignInPasswordChange("") },
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
            modifier = Modifier.fillMaxWidth(),
            onClickSignIn = onClickSignIn
        )
    }
}

@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    onClickSignIn: () -> Unit
) {
    Button(
        onClick = onClickSignIn,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(CustomTheme.colors.mainYellow),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(R.string.signin_signin_button), color = CustomTheme.colors.gray01
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowSignInScreen() {

}