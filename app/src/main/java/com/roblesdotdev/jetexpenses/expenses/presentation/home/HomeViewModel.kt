package com.roblesdotdev.jetexpenses.expenses.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetexpenses.expenses.domain.model.Expense
import com.roblesdotdev.jetexpenses.expenses.domain.repository.ReadExpensesRepository
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
        private val readExpensesRepository: ReadExpensesRepository,
    ) : ViewModel() {
        private val _state = MutableStateFlow(HomeState())
        val state = _state.asStateFlow()

        init {
            getInitialItems()
        }

        private fun getInitialItems() {
            viewModelScope.launch {
                val items = readExpensesRepository.getAllExpenses()
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
