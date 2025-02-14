package com.suwonsmartapp.data.repository

import com.suwonsmartapp.domain.model.Recipe
import com.suwonsmartapp.domain.repository.RecipeRepository

class RecipeRepositoryImpl : RecipeRepository {
    override suspend fun getRecipes(): List<Recipe> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipe(id: Int): Recipe {
        TODO("Not yet implemented")
    }
}