package com.roblesdotdev.jetexpenses.expenses.di

import android.content.Context
import androidx.room.Room
import com.roblesdotdev.jetexpenses.expenses.data.local.ExpenseDao
import com.roblesdotdev.jetexpenses.expenses.data.local.ExpensesDatabase
import com.roblesdotdev.jetexpenses.expenses.data.repository.ExpensesRepositoryImpl
import com.roblesdotdev.jetexpenses.expenses.domain.repository.ExpensesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Provides
    @Singleton
    fun providesAccessExpensesRepository(dao: ExpenseDao): ExpensesRepository {
        return ExpensesRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun providesDao(
        @ApplicationContext context: Context,
    ): ExpenseDao {
        return Room.databaseBuilder(
            context,
            ExpensesDatabase::class.java,
            "expenses_db",
        ).build().dao
    }
}
