package com.roblesdotdev.jetexpenses.expenses.presentation.detail

import com.roblesdotdev.jetexpenses.expenses.domain.model.ExpenseCategory
import java.util.UUID

data class DetailState(
    val id: UUID? = null,
    val inputAmount: String = "",
    val amount: Double? = null,
    val category: ExpenseCategory? = null,
    val description: String = "",
    val submitType: SubmitType = SubmitType.CREATE,
) {
    val appBarTitle = submitType.label
}

enum class SubmitType(val label: String) {
    CREATE("New Expense"),
    EDIT("Edit Expense"),
}
