package com.roblesdotdev.jetexpenses.expenses.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roblesdotdev.jetexpenses.expenses.domain.model.ExpenseCategory

@Composable
fun CategorySelector(
    category: ExpenseCategory?,
    onClick: () -> Unit,
) {
    val icon = category?.icon ?: Icons.Default.Check
    val text = category?.name?.uppercase() ?: "Select a category"
    Column {
        Text(text = "Category", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
        Surface(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.clickable { onClick() },
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .background(MaterialTheme.colorScheme.surface),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Icon(imageVector = icon, contentDescription = null, modifier = Modifier.padding(horizontal = 10.dp))
                Text(text = text)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null, modifier = Modifier.padding(horizontal = 8.dp))
            }
        }
    }
}
