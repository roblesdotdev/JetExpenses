package com.roblesdotdev.jetexpenses.expenses.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.jetexpenses.R
import com.roblesdotdev.jetexpenses.core.presentation.components.JEButton
import com.roblesdotdev.jetexpenses.core.presentation.components.JETopAppBar
import com.roblesdotdev.jetexpenses.expenses.domain.model.ExpenseCategory
import com.roblesdotdev.jetexpenses.expenses.presentation.detail.components.AmountTextField
import com.roblesdotdev.jetexpenses.expenses.presentation.detail.components.CategoryBottomSheetContent
import com.roblesdotdev.jetexpenses.expenses.presentation.detail.components.CategorySelector
import com.roblesdotdev.jetexpenses.expenses.presentation.detail.components.DescriptionTextField
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    state: DetailState,
    onEvent: (DetailEvent) -> Unit,
    onBack: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    val scopeCoroutine = rememberCoroutineScope()
    Scaffold(
        topBar = {
            JETopAppBar(state.appBarTitle, navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                    )
                }
            })
        },
    ) { paddingValues ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier.padding(top = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                AmountTextField(
                    value = state.inputAmount,
                    amount = state.amount,
                    onAmountChange = {
                        onEvent(DetailEvent.AmountChanged(it))
                    },
                )
                CategorySelector(
                    category = state.category,
                    onClick = {
                        showBottomSheet = true
                        scopeCoroutine.launch {
                            sheetState.show()
                        }
                    },
                )
                DescriptionTextField(
                    value = state.description,
                    onDescriptionChange = {
                        onEvent(DetailEvent.DescriptionChanged(it))
                    },
                )
            }
            JEButton(
                text = stringResource(R.string.save_expense_label),
                onClick = {
                    onEvent(DetailEvent.SaveExpense)
                    onBack()
                },
            )
        }
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
            ) {
                CategoryBottomSheetContent(
                    categories = ExpenseCategory.entries,
                    onSelectCategory = {
                        onEvent(DetailEvent.CategoryChanged(it))
                        showBottomSheet = false
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    JetExpensesTheme {
        DetailScreen(onBack = {}, onEvent = {}, state = DetailState())
    }
}
