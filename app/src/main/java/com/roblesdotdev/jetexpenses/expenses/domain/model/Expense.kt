package com.roblesdotdev.jetexpenses.expenses.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.ElectricCar
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.PartyMode
import androidx.compose.material.icons.filled.ViewCozy
import androidx.compose.ui.graphics.vector.ImageVector
import java.time.LocalDateTime
import java.util.UUID

data class Expense(
    val id: UUID = UUID.randomUUID(),
    val description: String,
    val category: ExpenseCategory,
    val amount: Double,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
    val icon = category.icon
    val title = category.name.uppercase()
}

enum class ExpenseCategory(val icon: ImageVector) {
    GROCERIES(Icons.Default.FoodBank),
    PARTY(Icons.Default.PartyMode),
    SNACKS(Icons.Default.Fastfood),
    COFFEE(Icons.Default.Coffee),
    CAR(Icons.Default.ElectricCar),
    HOUSE(Icons.Default.House),
    OTHER(Icons.Default.ViewCozy),
}
