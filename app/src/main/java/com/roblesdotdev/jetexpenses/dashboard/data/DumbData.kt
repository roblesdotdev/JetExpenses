package com.roblesdotdev.jetexpenses.dashboard.data

import com.roblesdotdev.jetexpenses.dashboard.domain.model.Expense
import com.roblesdotdev.jetexpenses.dashboard.domain.model.ExpenseCategory
import kotlin.random.Random

val dumbExpensesData =
    (1..15).map {
        Expense(
            id = "$it",
            title = "Expense title $it",
            description = "Description for expense $it",
            amount = 1 + Random.nextDouble() * (1200 - 1),
            category = ExpenseCategory.entries.random(),
        )
    }
