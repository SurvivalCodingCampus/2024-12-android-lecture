package com.surivalcoding.winterandroidstudy.day04.data.repository

import com.surivalcoding.winterandroidstudy.day04.data.model.Recipe

interface RecipeRepository {
    suspend fun getSavedRecipes(): List<Recipe>
}