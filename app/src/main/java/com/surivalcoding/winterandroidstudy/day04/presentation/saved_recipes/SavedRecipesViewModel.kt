package com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.winterandroidstudy.day04.core.util.Result
import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe
import com.surivalcoding.winterandroidstudy.day04.domain.use_case.DeleteBookmarkUseCase
import com.surivalcoding.winterandroidstudy.day04.domain.use_case.GetSavedRecipesUseCase
import com.surivalcoding.winterandroidstudy.day09_room.domain.model.User
import com.surivalcoding.winterandroidstudy.day09_room.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SavedRecipesViewModel(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _savedRecipes = MutableStateFlow<List<Recipe>>(emptyList())
    val savedRecipes = _savedRecipes.asStateFlow()

    private val _event = MutableSharedFlow<SavedRecipesEvent>()
    val event = _event.asSharedFlow()

    init {
        viewModelScope.launch {
            userRepository.upsert(User(name = "junsuk", age = 10))
            println(userRepository.getAll())

            when (val result = getSavedRecipesUseCase.execute()) {
                is Result.Error -> {
                    println(result.message)
                    _event.emit(SavedRecipesEvent.ShowSnackbar(result.message.toString()))
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
                    _event.emit(SavedRecipesEvent.ShowDialog("삭제 성공"))
                }
            }
        }
    }

}