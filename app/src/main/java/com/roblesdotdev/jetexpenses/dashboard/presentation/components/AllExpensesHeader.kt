package com.roblesdotdev.jetexpenses.dashboard.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun AllExpensesHeader() {
    Text(
        text = "All expenses",
        fontSize = 14.sp,
        color = MaterialTheme.colorScheme.onSurface,
    )
}
