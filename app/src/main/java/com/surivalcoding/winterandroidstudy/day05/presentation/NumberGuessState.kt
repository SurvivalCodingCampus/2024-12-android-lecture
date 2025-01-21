package com.surivalcoding.winterandroidstudy.day05.presentation

data class NumberGuessState(
    val numberText: String = "",
    val guessText: String? = null,
    val isCorrect: Boolean = false,
)