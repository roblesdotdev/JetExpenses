package com.roblesdotdev.jetexpenses.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.jetexpenses.navigation.NavigationHost
import com.roblesdotdev.jetexpenses.navigation.NavigationRoute
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel: MainViewModel by viewModels()

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !mainViewModel.state.value.isReady
            }
        }

        setContent {
            JetExpensesTheme {
                val mainState by mainViewModel.state.collectAsState()
                val navController = rememberNavController()
                val startDestination =
                    getStartDestination(
                        state = mainState,
                    )
                NavigationHost(
                    navController = navController,
                    startDestination = startDestination,
                )
            }
        }
    }

    private fun getStartDestination(state: MainState): NavigationRoute {
        return if (state.onboardingHasBeenSeen) {
            NavigationRoute.Dashboard
        } else {
            NavigationRoute.Onboarding
        }
    }
}
