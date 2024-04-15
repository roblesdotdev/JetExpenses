package com.roblesdotdev.jetexpenses.expenses.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.jetexpenses.expenses.domain.model.ExpenseCategory
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme

@Composable
fun CategoryBottomSheetContent(
    categories: List<ExpenseCategory>,
    paddingBottom: Int,
    onSelectCategory: (ExpenseCategory) -> Unit,
) {
    LazyVerticalGrid(
        modifier =
            Modifier
                .padding(16.dp)
                .padding(bottom = paddingBottom.dp),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center,
    ) {
        items(categories) { category ->
            CategoryItem(category, onClick = {
                onSelectCategory(category)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryBottomSheetContentPreview() {
    JetExpensesTheme {
        Surface {
            CategoryBottomSheetContent(
                categories = ExpenseCategory.entries,
                paddingBottom = 8,
                onSelectCategory = {},
            )
        }
    }
}
