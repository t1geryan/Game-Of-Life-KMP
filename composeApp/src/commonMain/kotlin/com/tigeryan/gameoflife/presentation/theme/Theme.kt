package com.tigeryan.gameoflife.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
internal fun AppTheme(
    spacing: Spacing = MaterialTheme.spacing,
    opacity: Opacity = MaterialTheme.opacity,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        isDarkTheme -> darkScheme
        else -> lightScheme
    }

    CompositionLocalProvider(
        LocalSpacing provides spacing,
        LocalOpacity provides opacity,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = appTypography,
            content = content
        )
    }
}