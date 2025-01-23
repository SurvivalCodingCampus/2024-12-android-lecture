package com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.winterandroidstudy.day04.core.util.Result
import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe
import com.surivalcoding.winterandroidstudy.day04.domain.use_case.DeleteBookmarkUseCase
import com.surivalcoding.winterandroidstudy.day04.domain.use_case.GetSavedRecipesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SavedRecipesViewModel(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
) : ViewModel() {

    private val _savedRecipes = MutableStateFlow<List<Recipe>>(emptyList())
    val savedRecipes = _savedRecipes.asStateFlow()

    init {
        viewModelScope.launch {
            when (val result = getSavedRecipesUseCase.execute()) {
                is Result.Error -> {
                    println(result.message)
                }

                is Result.Success -> {
                    _savedRecipes.value = result.data
                }
            }
        }
    }

    fun onDeleteBookmark(recipe: Recipe) {
        viewModelScope.launch {
            when (val result = deleteBookmarkUseCase.execute(recipe)) {
                is Result.Error -> {
                    println(result.message)
                }

                is Result.Success -> {
                    _savedRecipes.value = result.data
                }
            }
        }
    }

}