package com.roblesdotdev.jetexpenses.expenses.data.repository

import com.roblesdotdev.jetexpenses.expenses.data.dumbExpensesData
import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense
import com.roblesdotdev.jetexpenses.expenses.domain.repository.ExpensesRepository
import java.util.UUID

class ExpensesRepositoryImpl : ExpensesRepository {
    override suspend fun getAllExpenses(): Result<List<Expense>> {
        return Result.success(dumbExpensesData)
    }

    override suspend fun getExpenseById(id: UUID): Result<Expense> {
        val res = dumbExpensesData.indexOfFirst { it.id == id }
        return if (res == -1) {
            Result.failure(Exception("Not found expense with id $id"))
        } else {
            Result.success(dumbExpensesData[res])
        }
    }

    override suspend fun updateExpense(expense: Expense) {
        val expenseIndex = dumbExpensesData.indexOfFirst { it.id == expense.id }
        if (expenseIndex == -1) {
            dumbExpensesData.add(expense)
        } else {
            dumbExpensesData[expenseIndex] = expense
        }
    }
}
