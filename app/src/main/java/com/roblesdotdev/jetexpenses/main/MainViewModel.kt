package com.roblesdotdev.jetexpenses.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetexpenses.preferences.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(
        private val preferencesManager: PreferencesManager,
    ) : ViewModel() {
        private val _state = MutableStateFlow(MainState())
        val state = _state.asStateFlow()

        init {
            getPreferences()
            setIsReady()
        }

        private fun setIsReady() {
            viewModelScope.launch {
                delay(500L)
                _state.update { prevState ->
                    prevState.copy(isReady = true)
                }
            }
        }

        private fun getPreferences() {
            viewModelScope.launch {
                val hasBeenSeen = preferencesManager.getOnboardingHasBeenSeen()
                withContext(Dispatchers.Main) {
                    _state.update { prevState ->
                        prevState.copy(
                            onboardingHasBeenSeen = hasBeenSeen,
                        )
                    }
                }
            }
        }
    }
