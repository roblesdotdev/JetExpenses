package com.roblesdotdev.jetexpenses.core.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JEButton(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier =
            modifier
                .fillMaxWidth()
                .height(52.dp),
        shape = RoundedCornerShape(4.dp),
        colors =
            ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            ),
    ) {
        Text(text = stringResource(id = text), fontWeight = FontWeight.Bold, fontSize = 14.sp)
    }
}
