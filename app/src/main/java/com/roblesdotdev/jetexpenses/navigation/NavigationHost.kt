package com.roblesdotdev.jetexpenses.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.jetexpenses.dashboard.presentation.DashboardScreen
import com.roblesdotdev.jetexpenses.onboarding.presentation.OnboardingScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: NavigationRoute,
) {
    NavHost(navController = navController, startDestination = startDestination.route) {
        composable(NavigationRoute.Onboarding.route) {
            OnboardingScreen(
                onGetStarted = {
                    navController.popBackStack()
                    navController.navigate(NavigationRoute.Dashboard.route)
                },
            )
        }

        composable(NavigationRoute.Dashboard.route) {
            DashboardScreen(onFloatingActionClick = {})
        }
    }
}
