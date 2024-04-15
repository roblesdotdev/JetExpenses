@file:Suppress("ktlint")
package com.roblesdotdev.jetexpenses.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkScheme =
    darkColorScheme(
        primary = primaryColor,
        primaryContainer = primaryContainerColor,
        onPrimaryContainer = onPrimaryContainerColor,
        background = backgroundColor,
        onBackground = onBackgroundColor,
        surface = surfaceColor,
        onSurface = onSurfaceColor,
        secondaryContainer = secondaryContainerColor,
        onSecondaryContainer = onSecondaryContainerColor,
        errorContainer = errorContainerColor,
        onErrorContainer = onErrorContainerColor,
        error = errorColor,
    )

@Composable
fun JetExpensesTheme(
    content: @Composable () -> Unit,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = darkScheme.surface.toArgb()
            window.navigationBarColor = darkScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = darkScheme,
        typography = appTypography,
        content = content,
    )
}
