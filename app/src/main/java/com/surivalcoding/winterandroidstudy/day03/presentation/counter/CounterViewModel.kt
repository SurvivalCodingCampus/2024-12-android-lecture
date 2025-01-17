package com.surivalcoding.winterandroidstudy.day03.presentation.counter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.winterandroidstudy.day03.AppApplication
import com.surivalcoding.winterandroidstudy.day03.data.repository.NumberRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TestViewModel(
    private val state: SavedStateHandle,
): ViewModel() {

    fun load() {
        state.get<Int>("count")

        state["count"] = 10
    }
}

// Factory
class CounterViewModel(
    private val numberRepository: NumberRepository,
) : ViewModel() {

    private val _count: MutableStateFlow<Int> = MutableStateFlow(numberRepository.getNumber())
    val count: StateFlow<Int> = _count.asStateFlow()

    fun increase() {
        numberRepository.increaseNumber()
//        _count.value = numberRepository.getNumber()

        viewModelScope.launch {
            _count.emit(numberRepository.getNumber())
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return CounterViewModel(
                    (application as AppApplication).numberRepository,
                ) as T
            }
        }
    }
}