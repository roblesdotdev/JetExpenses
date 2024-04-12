package com.roblesdotdev.jetexpenses.preferences

class PreferencesManager(
    private val preferences: Preferences,
) {
    suspend fun getOnboardingHasBeenSeen(): Boolean {
        return preferences.getBoolean(ONBOARDING_HAS_BEEN_SEEN_KEY, false)
    }

    suspend fun setOnboardingASSeen() {
        preferences.setBoolean(ONBOARDING_HAS_BEEN_SEEN_KEY, true)
    }

    companion object {
        private const val ONBOARDING_HAS_BEEN_SEEN_KEY = "onboarding"
    }
}
