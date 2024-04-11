package com.roblesdotdev.jetexpenses.onboarding.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roblesdotdev.jetexpenses.BuildConfig
import com.roblesdotdev.jetexpenses.R

@Composable
fun OnboardingHeader() {
    Column {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                text = stringResource(R.string.version_label),
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = "v${BuildConfig.VERSION_NAME}",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 14.sp,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.app_description),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 16.sp,
        )
    }
}
