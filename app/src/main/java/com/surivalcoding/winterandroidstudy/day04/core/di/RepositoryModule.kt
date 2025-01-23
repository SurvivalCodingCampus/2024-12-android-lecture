package com.surivalcoding.winterandroidstudy.day04.core.di

import com.surivalcoding.winterandroidstudy.day04.data.repository.MockRecipeRepositoryImpl
import com.surivalcoding.winterandroidstudy.day04.domain.repository.BookmarkRepository
import com.surivalcoding.winterandroidstudy.day04.domain.repository.RecipeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<RecipeRepository> { MockRecipeRepositoryImpl() }

    single<BookmarkRepository> {
        object : BookmarkRepository {
            private val bookmarkIds = mutableListOf(1, 2, 3)
            override suspend fun getBookmarkIds(): List<Int> {
                return bookmarkIds
            }

            override suspend fun addBookmark(recipeId: Int) {
                bookmarkIds.add(recipeId)
            }

            override suspend fun removeBookmark(recipeId: Int) {
                bookmarkIds.remove(recipeId)
            }

        }
    }
}