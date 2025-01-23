package com.surivalcoding.winterandroidstudy.day04.domain.repository

interface BookmarkRepository {
    suspend fun getBookmarkIds(): List<Int>
    suspend fun addBookmark(recipeId: Int)
    suspend fun removeBookmark(recipeId: Int)
}