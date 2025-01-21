package com.surivalcoding.winterandroidstudy.day06.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.winterandroidstudy.data.repository.MockRecipeRepositoryImpl
import com.surivalcoding.winterandroidstudy.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchRecipesViewModel(
    private val recipeRepository: RecipeRepository = MockRecipeRepositoryImpl()
) : ViewModel() {
    private val _state = MutableStateFlow(SearchRecipesState())
    val state = _state.asStateFlow()

    init {
        fetchAllRecipes()
    }

    fun fetchRecipes(query: String) {
        if (query.isBlank()) {
            _state.update {
                it.copy(
                    query = query,
                    filteredRecipes = it.recipes,
                    resultTitle = "Recent Search",
                    resultCount = "",
                )
            }
            return
        }

        _state.update {
            it.copy(
                isLoading = true
            )
        }

        viewModelScope.launch {
            val filteredRecipes = state.value.recipes.filter {
                it.title.contains(query.lowercase(), ignoreCase = true)
                        || it.chef.contains(query, ignoreCase = true)
            }
            _state.update {
                it.copy(
                    query = query,
                    filteredRecipes = filteredRecipes,
                    isLoading = false,
                    resultTitle = "Search Result",
                    resultCount = "${filteredRecipes.size} results",
                )
            }
        }
    }

    fun fetchAllRecipes() {
        _state.update {
            it.copy(
                isLoading = true
            )
        }

        viewModelScope.launch {
            val recipes = recipeRepository.getSavedRecipes()
            _state.update {
                it.copy(
                    recipes = recipes,
                    filteredRecipes = recipes,
                    isLoading = false
                )
            }
        }
    }
}