package com.roblesdotdev.jetexpenses.expenses.di

import com.roblesdotdev.jetexpenses.expenses.data.repository.ReadExpensesRepositoryImpl
import com.roblesdotdev.jetexpenses.expenses.domain.repository.ReadExpensesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Provides
    @Singleton
    fun providesAccessExpensesRepository(): ReadExpensesRepository {
        return ReadExpensesRepositoryImpl()
    }
}
