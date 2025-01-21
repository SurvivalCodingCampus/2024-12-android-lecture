package com.surivalcoding.winterandroidstudy.day04

import android.app.Application
import com.surivalcoding.winterandroidstudy.data.repository.MockRecipeRepositoryImpl
import com.surivalcoding.winterandroidstudy.data.repository.RecipeRepository

class RecipeApplication: Application() {
    val recipeRepository: RecipeRepository by lazy {
        MockRecipeRepositoryImpl()
    }
}