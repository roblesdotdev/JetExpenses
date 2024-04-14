package com.roblesdotdev.jetexpenses.expenses.presentation.detail

import com.roblesdotdev.jetexpenses.expenses.domain.model.ExpenseCategory

sealed interface DetailEvent {
    data class AmountChanged(val amount: String) : DetailEvent

    data class DescriptionChanged(val description: String) : DetailEvent

    data class CategoryChanged(val category: ExpenseCategory) : DetailEvent
}
