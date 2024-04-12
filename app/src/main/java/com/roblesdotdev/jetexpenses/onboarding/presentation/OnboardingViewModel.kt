package com.roblesdotdev.jetexpenses.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetexpenses.preferences.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel
    @Inject
    constructor(
        private val preferencesManager: PreferencesManager,
    ) : ViewModel() {
        private val _state = MutableStateFlow(OnboardingState())
        val state = _state.asStateFlow()

        init {
            getInitialState()
        }

        fun onEvent(event: OnboardingEvent) {
            when (event) {
                OnboardingEvent.GetStarted -> onGetStarted()
            }
        }

        private fun onGetStarted() {
            viewModelScope.launch {
                preferencesManager.setOnboardingASSeen()
                _state.update { prevState ->
                    prevState.copy(
                        hasBeenSeen = true,
                    )
                }
            }
        }

        private fun getInitialState() {
            viewModelScope.launch {
                val onboardingHasBeenSeen = preferencesManager.getOnboardingHasBeenSeen()
                _state.update { prevState ->
                    prevState.copy(
                        hasBeenSeen = onboardingHasBeenSeen,
                    )
                }
            }
        }
    }
