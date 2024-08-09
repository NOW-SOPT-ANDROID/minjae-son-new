package com.sopt.now.compose.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object CustomTheme {
    val colors: CustomColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomColors.current

    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomTypography.current
}

@Composable
fun provideCustomColorsAndTypography(
    colors: CustomColors,
    typography: CustomTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalCustomColors provides colors,
        LocalCustomTypography provides typography,
        content = content,
    )
}

@Composable
fun CUSTOMTheme(content: @Composable () -> Unit) {
    val colors = defaultCustomColors
    val typography = defaultCustomTypography

    provideCustomColorsAndTypography(colors, typography) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            // SideEffect를 사용하여 상태 표시줄의 색상을 설정
            SideEffect {
                val window = (view.context as Activity).window
                window.statusBarColor = Color.White.toArgb() // 상태 표시줄 색상을 흰색으로 설정
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true // 상태 표시줄 아이콘 색상을 항상 검정색으로 설정
            }
        }
        MaterialTheme(content = content)
    }
}