package com.surivalcoding.winterandroidstudy.day03.presentation.counter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count: MutableState<Int> = mutableIntStateOf(0)
    val count: State<Int> = _count

    fun increase() {
        _count.value++
    }

    fun decrease() {
        _count.value--
    }
}