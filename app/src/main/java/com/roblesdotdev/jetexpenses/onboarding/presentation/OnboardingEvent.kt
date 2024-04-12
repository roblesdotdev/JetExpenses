package com.roblesdotdev.jetexpenses.onboarding.presentation

sealed interface OnboardingEvent {
    data object GetStarted : OnboardingEvent
}
