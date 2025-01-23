package com.surivalcoding.winterandroidstudy.day04.domain.use_case

import com.surivalcoding.winterandroidstudy.day04.core.util.Result
import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe
import com.surivalcoding.winterandroidstudy.day04.domain.repository.BookmarkRepository
import com.surivalcoding.winterandroidstudy.day04.domain.repository.RecipeRepository

class GetSavedRecipesUseCase(
    private val recipeRepository: RecipeRepository,
    private val bookmarkRepository: BookmarkRepository,
) {
    suspend fun execute(): Result<List<Recipe>> {
        return try {
            Result.Success(
                recipeRepository.getAllRecipes().filter {
                    bookmarkRepository.getBookmarkIds().contains(it.id)
                },
            )
        } catch (e: Exception) {
            Result.Error(
                message = "Saved 레시피 로드 에러",
                throwable = e,
            )
        }
    }
}