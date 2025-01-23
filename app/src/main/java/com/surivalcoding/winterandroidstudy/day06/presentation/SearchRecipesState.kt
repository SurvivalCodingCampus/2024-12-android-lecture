package com.surivalcoding.winterandroidstudy.day06.presentation

import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe

data class SearchRecipesState(
    val query: String = "",
    val recipes: List<Recipe> = emptyList(),
    val filteredRecipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,

    // 호불호
    val resultTitle: String = "Recent Search",
    val resultCount: String = "",
)