package com.roblesdotdev.jetexpenses.expenses.presentation.home

import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense

data class HomeState(
    val items: List<Expense> = emptyList(),
    val total: Double = 0.0,
)
