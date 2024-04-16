package com.roblesdotdev.jetexpenses.expenses.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roblesdotdev.jetexpenses.expenses.data.local.entity.ExpenseEntity

@Database(
    entities = [ExpenseEntity::class],
    version = 1,
)
abstract class ExpensesDatabase : RoomDatabase() {
    abstract val dao: ExpenseDao
}
