package com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes

sealed interface SavedRecipesEvent {
    data class ShowSnackbar(val message: String) : SavedRecipesEvent
    data class ShowDialog(val message: String) : SavedRecipesEvent
}