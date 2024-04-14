package com.roblesdotdev.jetexpenses.expenses.di

import com.roblesdotdev.jetexpenses.expenses.data.repository.ExpensesRepositoryImpl
import com.roblesdotdev.jetexpenses.expenses.domain.repository.ExpensesRepository
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
    fun providesAccessExpensesRepository(): ExpensesRepository {
        return ExpensesRepositoryImpl()
    }
}
