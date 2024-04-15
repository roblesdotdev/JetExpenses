package com.roblesdotdev.jetexpenses.expenses.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CurrencyLira
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.jetexpenses.core.presentation.components.JETopAppBar
import com.roblesdotdev.jetexpenses.expenses.data.dumbExpensesData
import com.roblesdotdev.jetexpenses.expenses.presentation.home.components.AllExpensesHeader
import com.roblesdotdev.jetexpenses.expenses.presentation.home.components.ExpenseItem
import com.roblesdotdev.jetexpenses.expenses.presentation.home.components.SwipeToDeleteContainer
import com.roblesdotdev.jetexpenses.expenses.presentation.home.components.TotalCard
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme
import java.util.UUID

@Composable
fun HomeScreen(
    state: HomeState,
    onFloatingActionClick: () -> Unit,
    onExpenseClick: (UUID) -> Unit,
    onDeleteExpense: (UUID) -> Unit,
    updateState: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        updateState()
    }
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
            JETopAppBar(title = "Dashboard", navigationIcon = {
                Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                    Icon(
                        imageVector = Icons.Default.CurrencyLira,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                }
            })
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
            items(items = state.items, key = { it.id }) { expense ->
                SwipeToDeleteContainer(item = expense, onDelete = {
                    onDeleteExpense(it.id)
                }) {
                    ExpenseItem(
                        expense,
                        onClick = { onExpenseClick(expense.id) },
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    JetExpensesTheme {
        HomeScreen(
            onFloatingActionClick = {},
            onExpenseClick = {},
            updateState = {},
            onDeleteExpense = {},
            state =
                HomeState(
                    items = dumbExpensesData,
                ),
        )
    }
}
