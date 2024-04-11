package com.roblesdotdev.jetexpenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetExpensesTheme {
                Text(text = "Jet Expenses")
            }
        }
    }
}
