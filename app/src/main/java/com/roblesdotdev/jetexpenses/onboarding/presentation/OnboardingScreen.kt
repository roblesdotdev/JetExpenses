package com.roblesdotdev.jetexpenses.onboarding.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.jetexpenses.R
import com.roblesdotdev.jetexpenses.core.presentation.components.JEButton
import com.roblesdotdev.jetexpenses.onboarding.presentation.components.OnboardingHeader
import com.roblesdotdev.jetexpenses.onboarding.presentation.components.OnboardingLogo
import com.roblesdotdev.jetexpenses.ui.theme.JetExpensesTheme

@Composable
fun OnboardingScreen(
    state: OnboardingState,
    onEvent: (OnboardingEvent) -> Unit,
    onGetStarted: () -> Unit,
) {
    LaunchedEffect(key1 = state.hasBeenSeen) {
        if (state.hasBeenSeen) {
            onGetStarted()
        }
    }
    Surface(
        modifier =
            Modifier
                .fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier =
                    Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                OnboardingLogo()
            }
            OnboardingHeader()
            Spacer(modifier = Modifier.height(64.dp))
            JEButton(text = R.string.get_started_label, onClick = {
                onEvent(OnboardingEvent.GetStarted)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    JetExpensesTheme {
        OnboardingScreen(onGetStarted = {}, state = OnboardingState(), onEvent = {})
    }
}
