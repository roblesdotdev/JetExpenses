package com.roblesdotdev.jetexpenses.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("expenseId")
            Surface(modifier = Modifier.fillMaxSize()) {
                Text(
                    text =
                        if (id == null) {
                            "Create expense"
                        } else {
                            "Edit expense with id $id"
                        },
                )
            }
        }
    }
}
