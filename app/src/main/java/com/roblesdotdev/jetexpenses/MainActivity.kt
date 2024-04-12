package com.roblesdotdev.jetexpenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.jetexpenses.navigation.NavigationHost
import com.roblesdotdev.jetexpenses.navigation.NavigationRoute
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetExpensesTheme {
                val navController = rememberNavController()
                NavigationHost(
                    navController = navController,
                    startDestination = NavigationRoute.Onboarding,
                )
            }
        }
    }
}
