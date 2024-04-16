package com.roblesdotdev.jetexpenses.expenses.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.roblesdotdev.jetexpenses.expenses.domain.model.ExpenseCategory
import java.util.UUID

@Entity("expenses")
@TypeConverters(Converter::class)
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: UUID,
    val description: String,
    val category: ExpenseCategory,
    val amount: Double,
    val createdAt: Long,
)

class Converter {
    @TypeConverter
    fun fromCategory(category: ExpenseCategory): String {
        return category.name
    }

    @TypeConverter
    fun toCategory(category: String): ExpenseCategory {
        return ExpenseCategory.valueOf(category)
    }
}
