package com.sopt.now.compose.presentation.ui.auth.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.R
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun SignUpTextButton(
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.signin_signup_button),
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
}