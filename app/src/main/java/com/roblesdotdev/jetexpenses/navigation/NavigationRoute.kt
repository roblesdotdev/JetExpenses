package com.roblesdotdev.jetexpenses.navigation

sealed class NavigationRoute(val route: String) {
    data object Onboarding : NavigationRoute("onboarding")

    data object Home : NavigationRoute("home")

    data object EditCreate : NavigationRoute("edit_create")
}
