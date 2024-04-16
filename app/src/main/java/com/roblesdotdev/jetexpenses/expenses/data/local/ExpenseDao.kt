package com.roblesdotdev.jetexpenses.expenses.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.roblesdotdev.jetexpenses.expenses.data.local.entity.ExpenseEntity
import java.util.UUID

@Dao
interface ExpenseDao {
    @Upsert
    suspend fun upsertExpense(expense: ExpenseEntity)

    @Query("SELECT * FROM expenses ORDER BY createdAt ASC")
    suspend fun getAllExpenses(): List<ExpenseEntity>

    @Query("SELECT * FROM expenses WHERE id == :id")
    suspend fun getExpenseById(id: UUID): ExpenseEntity

    @Query("DELETE FROM expenses WHERE id == :id")
    suspend fun deleteExpense(id: UUID)
}
