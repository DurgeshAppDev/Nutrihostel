package com.inflame.Nutrihostel.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = NutriGreen,
    onPrimary = NutriWhite,

    secondary = NutriOrange,
    onSecondary = NutriWhite,

    background = NutriBackground,
    onBackground = NutriTextPrimary,

    surface = NutriSurface,
    onSurface = NutriTextPrimary,

    surfaceVariant = NutriSurfaceVariant,
    onSurfaceVariant = NutriTextSecondary,

    error = NutriError,
    onError = NutriWhite,
)

private val DarkColorScheme = darkColorScheme(
    primary = NutriGreenLight,
    onPrimary = NutriBlack,

    secondary = NutriOrangeLight,
    onSecondary = NutriBlack,

    background = NutriTextPrimary,
    onBackground = NutriWhite,

    surface = ColorDarkSurface,
    onSurface = NutriWhite,

    surfaceVariant = ColorDarkSurfaceVariant,
    onSurfaceVariant = NutriTextLight,

    error = NutriError,
    onError = NutriWhite,
)

@Composable
fun NutriHostelTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) -> {
            val context = LocalContext.current

            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = NutriHostelTypography,
        content = content
    )
}