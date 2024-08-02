package com.sopt.now.compose.presentation.ui.auth.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.R
import com.sopt.now.compose.ui.theme.CustomTheme

@Composable
fun AuthTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    isFocused: Boolean,
    onFocusChanged: (Boolean) -> Unit,
    onRemove: () -> Unit,
    isPassword: Boolean = false,
    hint: String
) {
    Box(modifier = modifier) {
        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    onFocusChanged(focusState.isFocused)
                },
            textStyle = TextStyle(color = CustomTheme.colors.gray01),
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            cursorBrush = SolidColor(CustomTheme.colors.gray01),
            decorationBox = { innerTextField ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box {
                            if (value.text.isEmpty()) {
                                Text(
                                    text = hint,
                                    style = CustomTheme.typography.body1Medium,
                                    color = CustomTheme.colors.gray05
                                )
                            }
                            innerTextField()
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(id = R.drawable.ic_textfield_clear),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 6.dp)
                                .clickable { onRemove() }
                        )

                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(if (isFocused) CustomTheme.colors.mainYellow else CustomTheme.colors.gray05)
                    )
                }
            }
        )
    }
}