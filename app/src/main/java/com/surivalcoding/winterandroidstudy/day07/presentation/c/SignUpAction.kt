package com.surivalcoding.winterandroidstudy.day07.presentation.c

sealed interface SignUpAction {
    data object OnClickSignUp : SignUpAction
    data object OnClickTerms : SignUpAction
    data class InputName(val name: String) : SignUpAction
    data class InputEmail(val email: String) : SignUpAction
}