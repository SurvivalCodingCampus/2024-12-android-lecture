package com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.winterandroidstudy.data.model.Recipe
import com.surivalcoding.winterandroidstudy.data.repository.RecipeRepository
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
}