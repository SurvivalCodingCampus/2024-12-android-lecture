package com.surivalcoding.winterandroidstudy.day07.presentation.c

import com.surivalcoding.winterandroidstudy.data.model.Recipe

data class SignUpState(
    val query: String = "",
    val recipes: List<Recipe> = emptyList(),
    val filteredRecipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,

    // 호불호
    val resultTitle: String = "Recent Search",
    val resultCount: String = "",
)