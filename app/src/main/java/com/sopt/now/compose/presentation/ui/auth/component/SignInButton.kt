package com.sopt.now.compose.presentation.ui.auth.component

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.R
import com.sopt.now.compose.presentation.utils.showToast
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun SignInButton(
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
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(CustomTheme.colors.mainYellow),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(R.string.signin_signin_button),
            color = CustomTheme.colors.gray01
        )
    }
}