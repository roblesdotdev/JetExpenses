package com.roblesdotdev.jetexpenses.dashboard.data.repository

import com.roblesdotdev.jetexpenses.dashboard.data.dumbExpensesData
import com.roblesdotdev.jetexpenses.dashboard.domain.model.Expense
import com.roblesdotdev.jetexpenses.dashboard.domain.repository.AccessExpensesRepository

class AccessExpensesRepositoryImpl : AccessExpensesRepository {
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
