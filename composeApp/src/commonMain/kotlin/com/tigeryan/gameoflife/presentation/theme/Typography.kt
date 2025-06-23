package com.tigeryan.gameoflife.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import gameoflife.composeapp.generated.resources.DavidLibre_Bold
import gameoflife.composeapp.generated.resources.DavidLibre_Medium
import gameoflife.composeapp.generated.resources.DavidLibre_Regular
import gameoflife.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font


// Default Material 3 typography values
internal val fontBaseLine = Typography()

val appTypography: Typography
    @Composable
    get() {
        val displayFontFamily = FontFamily(
            Font(Res.font.DavidLibre_Regular),
            Font(Res.font.DavidLibre_Medium),
            Font(Res.font.DavidLibre_Bold),
        )
        return fontBaseLine.copy(
            displayLarge = fontBaseLine.displayLarge.copy(fontFamily = displayFontFamily),
            displayMedium = fontBaseLine.displayMedium.copy(fontFamily = displayFontFamily),
            displaySmall = fontBaseLine.displaySmall.copy(fontFamily = displayFontFamily),
            headlineLarge = fontBaseLine.headlineLarge.copy(fontFamily = displayFontFamily),
            headlineMedium = fontBaseLine.headlineMedium.copy(fontFamily = displayFontFamily),
            headlineSmall = fontBaseLine.headlineSmall.copy(fontFamily = displayFontFamily),
            titleLarge = fontBaseLine.titleLarge.copy(fontFamily = displayFontFamily),
            titleMedium = fontBaseLine.titleMedium.copy(fontFamily = displayFontFamily),
            titleSmall = fontBaseLine.titleSmall.copy(fontFamily = displayFontFamily),
        )
    }