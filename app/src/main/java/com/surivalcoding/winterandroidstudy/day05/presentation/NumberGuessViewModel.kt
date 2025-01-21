package com.surivalcoding.winterandroidstudy.day05.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class NumberGuessViewModel : ViewModel() {
    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    private val number = Random.nextInt(10)

    fun onGuessClick() {
        val guess = state.value.numberText.toIntOrNull()

        _state.update {
            it.copy(
                guessText = when {
                    guess == null -> "숫자를 입력하세요"
                    guess < number -> "UP"
                    guess > number -> "DOWN"
                    else -> "정답"
                },
                isCorrect = guess == number,
                numberText = "",
            )
        }
    }

    fun onNumberTextChange(newText: String) {
//        _state.value = state.value.copy(
//            numberText = newText
//        )

        _state.update {
            it.copy(
                numberText = newText
            )
        }
    }
}