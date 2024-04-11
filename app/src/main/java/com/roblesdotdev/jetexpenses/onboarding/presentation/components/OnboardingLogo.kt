package com.roblesdotdev.jetexpenses.onboarding.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyLira
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingLogo() {
    Surface(
        modifier =
            Modifier
                .padding(32.dp)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = .05f),
                    shape = RoundedCornerShape(32.dp),
                ),
        shape = RoundedCornerShape(32.dp),
    ) {
        Icon(
            modifier =
                Modifier
                    .padding(32.dp)
                    .size(64.dp),
            imageVector = Icons.Default.CurrencyLira,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground,
        )
    }
}
