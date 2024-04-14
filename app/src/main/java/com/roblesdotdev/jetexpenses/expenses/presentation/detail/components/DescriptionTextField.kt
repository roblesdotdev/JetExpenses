package com.roblesdotdev.jetexpenses.expenses.presentation.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.roblesdotdev.jetexpenses.core.presentation.components.JETextField

@Composable
fun DescriptionTextField(
    value: String,
    onDescriptionChange: (String) -> Unit,
) {
    Column {
        Text(text = "Description", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
        JETextField(
            value = value,
            onValueChange = onDescriptionChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Expense description",
        )
    }
}
