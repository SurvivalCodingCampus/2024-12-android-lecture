package com.surivalcoding.winterandroidstudy.day04.domain.use_case

import com.surivalcoding.winterandroidstudy.day04.core.util.Result
import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe
import com.surivalcoding.winterandroidstudy.day04.domain.repository.BookmarkRepository

class DeleteBookmarkUseCase(
    private val bookmarkRepository: BookmarkRepository,
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
) {
    suspend fun execute(recipe: Recipe): Result<List<Recipe>> {
        try {
            bookmarkRepository.removeBookmark(recipe.id)
            return getSavedRecipesUseCase.execute()
        } catch (e: Exception) {
            return Result.Error(
                e.message ?: "북마크 제거 중 알수 없는 에러",
                throwable = e
            )
        }
    }
}