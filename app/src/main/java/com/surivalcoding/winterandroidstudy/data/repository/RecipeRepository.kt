package com.surivalcoding.winterandroidstudy.data.repository

import com.surivalcoding.winterandroidstudy.data.model.Recipe

interface RecipeRepository {
    suspend fun getSavedRecipes(): List<Recipe>
}