package com.roblesdotdev.jetexpenses.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                    navController.navigate(NavigationRoute.Home.route)
                },
            )
        }

        composable(NavigationRoute.Home.route) {
            Text(text = "Home Screen")
        }
    }
}
