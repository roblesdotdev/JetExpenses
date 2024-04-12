package com.roblesdotdev.jetexpenses.onboarding.di

import android.content.Context
import com.roblesdotdev.jetexpenses.preferences.AndroidPreferences
import com.roblesdotdev.jetexpenses.preferences.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardingModule {
    @Provides
    @Singleton
    fun providesPreferenceManager(
        @ApplicationContext context: Context,
    ): PreferencesManager {
        val androidPreferences =
            AndroidPreferences(
                sharedPreferences = context.getSharedPreferences("je_preferences", Context.MODE_PRIVATE),
            )
        return PreferencesManager(preferences = androidPreferences)
    }
}
