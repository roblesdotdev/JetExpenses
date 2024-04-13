package com.roblesdotdev.jetexpenses.dashboard.presentation

import com.roblesdotdev.jetexpenses.dashboard.domain.model.Expense

data class DashboardState(
    val items: List<Expense> = emptyList(),
    val total: Double = 0.0,
)
