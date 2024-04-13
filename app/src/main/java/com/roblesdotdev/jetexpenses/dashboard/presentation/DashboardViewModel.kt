package com.roblesdotdev.jetexpenses.dashboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetexpenses.dashboard.domain.model.Expense
import com.roblesdotdev.jetexpenses.dashboard.domain.repository.AccessExpensesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
    @Inject
    constructor(
        private val accessExpensesRepository: AccessExpensesRepository,
    ) : ViewModel() {
        private val _state = MutableStateFlow(DashboardState())
        val state = _state.asStateFlow()

        init {
            getInitialItems()
        }

        private fun getInitialItems() {
            viewModelScope.launch {
                val items = accessExpensesRepository.getAllExpenses()
                updateState(items)
            }
        }

        private fun updateState(items: Result<List<Expense>>) {
            items.fold(
                onSuccess = { expenses ->
                    _state.update { prevState ->
                        prevState.copy(
                            items = expenses,
                            total = expenses.sumOf { it.amount },
                        )
                    }
                },
                onFailure = {
                    // TODO
                },
            )
        }
    }
