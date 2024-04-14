package com.roblesdotdev.jetexpenses.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.roblesdotdev.jetexpenses.expenses.presentation.detail.DetailScreen
import com.roblesdotdev.jetexpenses.expenses.presentation.detail.DetailViewModel
import com.roblesdotdev.jetexpenses.expenses.presentation.home.HomeScreen
import com.roblesdotdev.jetexpenses.expenses.presentation.home.HomeViewModel
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
                    navController.navigate(NavigationRoute.Home.route)
                },
            )
        }

        composable(NavigationRoute.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            val homeState by homeViewModel.state.collectAsState()
            HomeScreen(
                onFloatingActionClick = {
                    navController.navigate(NavigationRoute.EditCreate.route)
                },
                onExpenseClick = {
                    navController.navigate(NavigationRoute.EditCreate.route + "?expenseId=$it")
                },
                updateState = homeViewModel::updateState,
                state = homeState,
            )
        }

        composable(
            NavigationRoute.EditCreate.route + "?expenseId={expenseId}",
            arguments =
                listOf(
                    navArgument("expenseId") {
                        type = NavType.StringType
                        nullable = true
                    },
                ),
        ) {
            val detailViewModel: DetailViewModel = hiltViewModel()
            val detailState by detailViewModel.state.collectAsState()
            DetailScreen(
                state = detailState,
                onEvent = detailViewModel::onEvent,
                onBack = {
                    navController.popBackStack()
                },
            )
        }
    }
}
