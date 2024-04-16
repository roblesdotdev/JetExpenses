package com.roblesdotdev.jetexpenses.expenses.data.repository

import com.roblesdotdev.jetexpenses.expenses.data.local.ExpenseDao
import com.roblesdotdev.jetexpenses.expenses.data.local.mapper.toDomain
import com.roblesdotdev.jetexpenses.expenses.data.local.mapper.toEntity
import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense
import com.roblesdotdev.jetexpenses.expenses.domain.repository.ExpensesRepository
import java.util.UUID

class ExpensesRepositoryImpl(
    private val dao: ExpenseDao,
) : ExpensesRepository {
    override suspend fun getAllExpenses(): Result<List<Expense>> {
        val expenses =
            dao.getAllExpenses().map {
                it.toDomain()
            }
        return Result.success(expenses)
    }

    override suspend fun getExpenseById(id: UUID): Result<Expense> {
        return try {
            val expense = dao.getExpenseById(id)
            Result.success(expense.toDomain())
        } catch (e: Exception) {
            Result.failure(Exception("Not found expense with id $id"))
        }
    }

    override suspend fun updateExpense(expense: Expense) {
        dao.upsertExpense(expense.toEntity())
    }

    override suspend fun deleteExpense(expenseId: UUID) {
        dao.deleteExpense(expenseId)
    }
}
