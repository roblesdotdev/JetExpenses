package com.roblesdotdev.jetexpenses.expenses.domain.repository

import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense
import java.util.UUID

interface ExpensesRepository {
    suspend fun getLatestExpenses(): Result<List<Expense>>

    suspend fun getExpenseById(id: UUID): Result<Expense>

    suspend fun updateExpense(expense: Expense)

    suspend fun deleteExpense(expenseId: UUID)
}
