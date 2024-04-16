package com.roblesdotdev.jetexpenses.expenses.presentation.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme

@Composable
fun EmptyListHeader(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "No expenses yet!",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = modifier,
        )
        TextButton(onClick = onClick) {
            Text(text = "Try adding one.", fontSize = 14.sp)
        }
    }
}

@Preview
@Composable
private fun EmptyListHeaderPreview() {
    JetExpensesTheme {
        EmptyListHeader {
        }
    }
}
