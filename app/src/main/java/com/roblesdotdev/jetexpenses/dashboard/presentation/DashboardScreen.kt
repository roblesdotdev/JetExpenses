package com.roblesdotdev.jetexpenses.dashboard.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.roblesdotdev.jetexpenses.dashboard.presentation.components.AllExpensesHeader
import com.roblesdotdev.jetexpenses.dashboard.presentation.components.DashboardTopBar
import com.roblesdotdev.jetexpenses.dashboard.presentation.components.ExpenseItem
import com.roblesdotdev.jetexpenses.dashboard.presentation.components.TotalCard
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme

@Composable
fun DashboardScreen(onFloatingActionClick: () -> Unit) {
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
                    .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                TotalCard(total = 1200.32)
            }
            item {
                AllExpensesHeader()
            }
            item {
                repeat(15) {
                    ExpenseItem()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    JetExpensesTheme {
        DashboardScreen(onFloatingActionClick = {})
    }
}
