package com.roblesdotdev.jetexpenses.expenses.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense
import com.roblesdotdev.jetexpenses.expenses.domain.repository.ExpensesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val expensesRepository: ExpensesRepository,
    ) : ViewModel() {
        private val _state = MutableStateFlow(HomeState())
        val state = _state.asStateFlow()
        private lateinit var allExpenses: List<Expense>

        init {
            viewModelScope.launch {
                allExpenses = expensesRepository.getAllExpenses().getOrDefault(emptyList())
            }
            updateState()
        }

        private fun getAllExpenses() {
            viewModelScope.launch {
                updateState()
            }
        }

        fun updateState() {
            _state.update { prevState ->
                prevState.copy(
                    items = allExpenses,
                    total = allExpenses.sumOf { it.amount },
                )
            }
        }
    }
