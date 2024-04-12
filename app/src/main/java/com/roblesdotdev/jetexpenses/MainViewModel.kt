package com.roblesdotdev.jetexpenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetexpenses.preferences.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(
        private val preferencesManager: PreferencesManager,
    ) : ViewModel() {
        val onboardingHasBeenSeen = MutableStateFlow(false)

        init {
            getPreferences()
        }

        private fun getPreferences() {
            viewModelScope.launch {
                val hasBeenSeen = preferencesManager.getOnboardingHasBeenSeen()
                onboardingHasBeenSeen.update { hasBeenSeen }
            }
        }
    }
