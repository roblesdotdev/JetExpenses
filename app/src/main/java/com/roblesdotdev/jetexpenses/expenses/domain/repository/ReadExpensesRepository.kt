package com.roblesdotdev.jetexpenses.expenses.domain.repository

import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense

interface ReadExpensesRepository {
    suspend fun getAllExpenses(): Result<List<Expense>>

    suspend fun getExpenseById(id: String): Result<Expense>
}
