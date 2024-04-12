package com.roblesdotdev.jetexpenses.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.jetexpenses.dashboard.presentation.DashboardScreen
import com.roblesdotdev.jetexpenses.onboarding.presentation.OnboardingScreen
import com.roblesdotdev.jetexpenses.onboarding.presentation.OnboardingViewModel

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: NavigationRoute,
) {
    NavHost(navController = navController, startDestination = startDestination.route) {
        composable(NavigationRoute.Onboarding.route) {
            val onboardingViewModel: OnboardingViewModel = hiltViewModel()
            val onboardingState by onboardingViewModel.state.collectAsState()
            OnboardingScreen(
                state = onboardingState,
                onEvent = onboardingViewModel::onEvent,
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
