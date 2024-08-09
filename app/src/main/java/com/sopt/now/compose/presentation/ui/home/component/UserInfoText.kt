package com.sopt.now.compose.presentation.ui.home.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun UserInfoText(
    title: String,
    value: String
) {
    Text(
        text = title,
        color = CustomTheme.colors.gray01,
        style = CustomTheme.typography.head2
    )
    Spacer(modifier = Modifier.height(14.dp))
    Text(
        text = value,
        color = CustomTheme.colors.gray03,
        style = CustomTheme.typography.body1Medium
    )
}