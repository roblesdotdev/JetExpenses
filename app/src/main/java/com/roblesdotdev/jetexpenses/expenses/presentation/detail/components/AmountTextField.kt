package com.roblesdotdev.jetexpenses.expenses.presentation.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyLira
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roblesdotdev.jetexpenses.core.presentation.components.JETextField

@Composable
fun AmountTextField(
    value: String,
    amount: Double?,
    onAmountChange: (String) -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth(),
    ) {
        Text(text = "Amount", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
        JETextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onAmountChange,
            keyboardOptions =
                KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number,
                ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.CurrencyLira,
                    contentDescription = null,
                )
            },
            trailingIcon = {
                Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                    Text(
                        text = "$%.2f".format(amount ?: 0.0),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 14.sp,
                    )
                }
            },
        )
    }
}
