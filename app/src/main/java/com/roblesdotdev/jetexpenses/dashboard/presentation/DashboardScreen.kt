package com.roblesdotdev.jetexpenses.dashboard.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.jetexpenses.dashboard.data.dumbExpensesData
import com.roblesdotdev.jetexpenses.dashboard.presentation.components.AllExpensesHeader
import com.roblesdotdev.jetexpenses.dashboard.presentation.components.DashboardTopBar
import com.roblesdotdev.jetexpenses.dashboard.presentation.components.ExpenseItem
import com.roblesdotdev.jetexpenses.dashboard.presentation.components.TotalCard
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme

@Composable
fun DashboardScreen(
    state: DashboardState,
    onFloatingActionClick: () -> Unit,
    onExpenseClick: (String) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onFloatingActionClick,
                shape = RoundedCornerShape(8.dp),
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        topBar = {
            DashboardTopBar()
        },
    ) { paddingValues ->
        LazyColumn(
            modifier =
                Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                TotalCard(
                    total = state.total,
                    modifier =
                        Modifier
                            .fillMaxWidth(),
                )
            }
            item {
                AllExpensesHeader(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                )
            }
            items(state.items) { expense ->
                ExpenseItem(
                    expense,
                    onClick = { onExpenseClick(expense.id) },
                )
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    JetExpensesTheme {
        DashboardScreen(
            onFloatingActionClick = {},
            onExpenseClick = {},
            state =
                DashboardState(
                    items = dumbExpensesData,
                ),
        )
    }
}
