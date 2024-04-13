package com.roblesdotdev.jetexpenses.dashboard.domain.repository

import com.roblesdotdev.jetexpenses.dashboard.domain.model.Expense

interface AccessExpensesRepository {
    suspend fun getAllExpenses(): Result<List<Expense>>

    suspend fun getExpenseById(id: String): Result<Expense>
}
