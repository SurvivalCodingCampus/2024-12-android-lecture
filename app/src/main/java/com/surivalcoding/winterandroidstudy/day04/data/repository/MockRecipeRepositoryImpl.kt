package com.surivalcoding.winterandroidstudy.day04.data.repository

import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe
import com.surivalcoding.winterandroidstudy.day04.domain.repository.RecipeRepository

class MockRecipeRepositoryImpl : RecipeRepository {
    override suspend fun getAllRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                id = 1,
                title = "Traditional spare ribs baked",
                chef = "Chef John"
            ),
            Recipe(
                id = 2,
                title = "Spice roasted chicken with flavored rice",
                chef = "Mark Kelvin"
            ),
            Recipe(
                id = 3,
                title = "Spicy fried rice mix chicken bali",
                chef = "Spicy Nelly"
            ),
            Recipe(
                id = 4,
                title = "Ttekbokki",
                chef = "Kim Dahee"
            ),
            Recipe(
                title = "Grilled salmon with avocado salsa",
                chef = "Alice Johnson"
            ),
            Recipe(
                title = "Beef Wellington",
                chef = "Gordon Ramsay"
            ),
            Recipe(
                title = "Classic Margherita Pizza",
                chef = "Mario Batali"
            ),
            Recipe(
                title = "Sushi Platter",
                chef = "Jiro Ono"
            ),
            Recipe(
                title = "French Onion Soup",
                chef = "Julia Child"
            ),
            Recipe(
                title = "Chocolate Lava Cake",
                chef = "Paul Hollywood"
            )
        )
    }
}