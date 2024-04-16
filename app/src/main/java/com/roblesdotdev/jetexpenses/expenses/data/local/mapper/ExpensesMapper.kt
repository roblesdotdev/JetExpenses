package com.roblesdotdev.jetexpenses.expenses.data.local.mapper

import com.roblesdotdev.jetexpenses.expenses.data.local.entity.ExpenseEntity
import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

fun ExpenseEntity.toDomain(): Expense {
    return Expense(
        id = this.id,
        category = this.category,
        description = this.description,
        amount = this.amount,
        createdAt =
            Instant.ofEpochMilli(this.createdAt).atZone(ZoneId.systemDefault())
                .toLocalDateTime(),
    )
}

fun Expense.toEntity(): ExpenseEntity {
    return ExpenseEntity(
        id = this.id,
        category = this.category,
        description = this.description,
        amount = this.amount,
        createdAt =
            ZonedDateTime.of(this.createdAt, ZoneId.systemDefault()).toInstant()
                .toEpochMilli(),
    )
}
