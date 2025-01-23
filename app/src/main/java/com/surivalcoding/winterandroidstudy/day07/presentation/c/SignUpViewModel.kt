package com.surivalcoding.winterandroidstudy.day07.presentation.c

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.toRoute
import com.surivalcoding.winterandroidstudy.day04.data.repository.MockRecipeRepositoryImpl
import com.surivalcoding.winterandroidstudy.day04.domain.repository.RecipeRepository
import com.surivalcoding.winterandroidstudy.day07.presentation.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val recipeRepository: RecipeRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(SignUpState())
    val state = _state.asStateFlow()

    init {
        fetchAllRecipes()

        val id = savedStateHandle.toRoute<Route.SignUp>().id
        println(id)
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
            val recipes = recipeRepository.getAllRecipes()
            _state.update {
                it.copy(
                    recipes = recipes,
                    filteredRecipes = recipes,
                    isLoading = false
                )
            }
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

                return SignUpViewModel(
                    recipeRepository = MockRecipeRepositoryImpl(),
                    savedStateHandle = savedStateHandle,
                ) as T
            }
        }
    }
}