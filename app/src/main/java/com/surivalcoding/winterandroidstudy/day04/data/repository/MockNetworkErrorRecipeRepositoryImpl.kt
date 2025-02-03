package com.surivalcoding.winterandroidstudy.day04.data.repository

import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe
import com.surivalcoding.winterandroidstudy.day04.domain.repository.RecipeRepository
import okio.IOException

class MockNetworkErrorRecipeRepositoryImpl : RecipeRepository {
    override suspend fun getAllRecipes(): List<Recipe> {
        throw IOException("Network Error")
    }
}