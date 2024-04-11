package com.roblesdotdev.jetexpenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetExpensesTheme {
                Scaffold { paddingValues ->
                    Box(
                        modifier =
                            Modifier
                                .padding(paddingValues)
                                .padding(horizontal = 20.dp, vertical = 32.dp),
                    ) {
                        Text(text = "Jet Expenses")
                    }
                }
            }
        }
    }
}
