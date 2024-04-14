package com.roblesdotdev.jetexpenses.expenses.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetexpenses.expenses.domain.model.ExpenseCategory
import com.roblesdotdev.jetexpenses.expenses.domain.repository.ReadExpensesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
    @Inject
    constructor(
        savedStateHandle: SavedStateHandle,
        private val readExpensesRepository: ReadExpensesRepository,
    ) : ViewModel() {
        private val _state = MutableStateFlow(DetailState())
        val state = _state.asStateFlow()

        init {
            val id = savedStateHandle.get<String?>("expenseId")
            id?.let {
                loadExpenseData(id)
            }
        }

        fun onEvent(event: DetailEvent) {
            when (event) {
                is DetailEvent.AmountChanged -> updateAmount(event.amount)
                is DetailEvent.DescriptionChanged -> updateDescription(event.description)
                is DetailEvent.CategoryChanged -> updateCategory(event.category)
            }
        }

        private fun updateAmount(amount: String) {
            _state.update { prevState ->
                prevState.copy(
                    amount = amount.toDoubleOrNull(),
                    inputAmount = amount,
                )
            }
        }

        private fun updateDescription(description: String) {
            _state.update { prevState ->
                prevState.copy(
                    description = description,
                )
            }
        }

        private fun updateCategory(category: ExpenseCategory) {
            _state.update { prevState ->
                prevState.copy(
                    category = category,
                )
            }
        }

        private fun loadExpenseData(id: String) {
            _state.update { prevState ->
                prevState.copy(
                    submitType = SubmitType.EDIT,
                )
            }
            viewModelScope.launch {
                val expenseResult = readExpensesRepository.getExpenseById(id)
                expenseResult.fold(
                    onSuccess = { expense ->
                        _state.update { prevState ->
                            prevState.copy(
                                amount = expense.amount,
                                inputAmount = "%.2f".format(expense.amount),
                                description = expense.description,
                                category = expense.category,
                            )
                        }
                    },
                    onFailure = {},
                )
            }
        }
    }
