package com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.winterandroidstudy.day04.RecipeApplication
import com.surivalcoding.winterandroidstudy.day04.data.model.Recipe
import com.surivalcoding.winterandroidstudy.day04.data.repository.RecipeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SavedRecipesViewModel(
    private val recipeRepository: RecipeRepository,
) : ViewModel() {

    private val _savedRecipes = MutableStateFlow<List<Recipe>>(emptyList())
    val savedRecipes = _savedRecipes.asStateFlow()

    init {
        fetchSavedRecipes()
    }

    fun fetchSavedRecipes() {
        viewModelScope.launch {
            delay(2000)
            val recipes = recipeRepository.getSavedRecipes()
            _savedRecipes.value = recipes
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

                return SavedRecipesViewModel(
                    (application as RecipeApplication).recipeRepository,
                ) as T
            }
        }
    }
}