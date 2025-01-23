package com.surivalcoding.winterandroidstudy.day04.domain.repository

import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe

interface RecipeRepository {
    suspend fun getAllRecipes(): List<Recipe>
}