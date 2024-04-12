package com.roblesdotdev.jetexpenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.jetexpenses.navigation.NavigationHost
import com.roblesdotdev.jetexpenses.navigation.NavigationRoute
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetExpensesTheme {
                val viewModel: MainViewModel = hiltViewModel()
                val navController = rememberNavController()
                val startDestination =
                    getStartDestination(
                        hasBeenSeen = viewModel.onboardingHasBeenSeen.collectAsState().value,
                    )
                NavigationHost(
                    navController = navController,
                    startDestination = startDestination,
                )
            }
        }
    }

    private fun getStartDestination(hasBeenSeen: Boolean): NavigationRoute {
        return if (hasBeenSeen) {
            NavigationRoute.Dashboard
        } else {
            NavigationRoute.Onboarding
        }
    }
}
