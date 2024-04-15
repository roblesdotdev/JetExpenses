package com.roblesdotdev.jetexpenses.expenses.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense

@Composable
fun ExpenseItem(
    expense: Expense,
    onClick: () -> Unit = {},
) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable { onClick() },
        shape = RoundedCornerShape(4.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onBackground,
            ),
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Surface(
                color = Color.White.copy(alpha = .05f),
                shape = RoundedCornerShape(8.dp),
            ) {
                Icon(
                    modifier =
                        Modifier
                            .padding(12.dp)
                            .size(20.dp),
                    imageVector = expense.icon,
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(text = expense.title.uppercase(), fontWeight = FontWeight.Medium)
                Text(
                    text = expense.description,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
            Text(text = "$%.2f".format(expense.amount))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteBackground(swipeDismissState: SwipeToDismissBoxState) {
    val color =
        if (swipeDismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart) {
            MaterialTheme.colorScheme.errorContainer
        } else {
            Color.Transparent
        }

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(color)
                .padding(16.dp),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Icon(imageVector = Icons.Default.Delete, contentDescription = null)
    }
}
