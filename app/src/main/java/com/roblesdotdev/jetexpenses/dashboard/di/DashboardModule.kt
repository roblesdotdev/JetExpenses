package com.roblesdotdev.jetexpenses.dashboard.di

import com.roblesdotdev.jetexpenses.dashboard.data.repository.AccessExpensesRepositoryImpl
import com.roblesdotdev.jetexpenses.dashboard.domain.repository.AccessExpensesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {
    @Provides
    @Singleton
    fun providesAccessExpensesRepository(): AccessExpensesRepository {
        return AccessExpensesRepositoryImpl()
    }
}
