package com.suwonsmartapp.domain.repository

import com.suwonsmartapp.domain.model.Recipe

interface RecipeRepository {
    suspend fun getRecipes(): List<Recipe>
    suspend fun getRecipe(id: Int): Recipe
}