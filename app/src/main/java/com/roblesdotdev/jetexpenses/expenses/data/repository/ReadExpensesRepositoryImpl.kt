package com.roblesdotdev.jetexpenses.expenses.data.repository

import com.roblesdotdev.jetexpenses.expenses.data.dumbExpensesData
import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense
import com.roblesdotdev.jetexpenses.expenses.domain.repository.ReadExpensesRepository

class ReadExpensesRepositoryImpl : ReadExpensesRepository {
    override suspend fun getAllExpenses(): Result<List<Expense>> {
        return Result.success(dumbExpensesData)
    }

    override suspend fun getExpenseById(id: String): Result<Expense> {
        val res = dumbExpensesData.indexOfFirst { it.id == id }
        return if (res == -1) {
            Result.failure(Exception("Not found expense with id $id"))
        } else {
            Result.success(dumbExpensesData[res])
        }
    }
}
