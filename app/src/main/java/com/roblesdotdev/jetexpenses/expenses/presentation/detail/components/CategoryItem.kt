package com.roblesdotdev.jetexpenses.expenses.presentation.detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.roblesdotdev.jetexpenses.expenses.domain.model.ExpenseCategory

@Composable
fun CategoryItem(
    category: ExpenseCategory,
    onClick: () -> Unit,
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier =
            Modifier
                .clip(
                    RoundedCornerShape(8.dp),
                )
                .clickable { onClick() },
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = category.icon,
                contentDescription = null,
                modifier =
                    Modifier
                        .size(32.dp)
                        .clip(CircleShape),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = category.name.uppercase(), fontWeight = FontWeight.Medium)
        }
    }
}
